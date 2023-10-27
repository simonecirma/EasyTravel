package model;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class immaginiModel {
	
	static Logger logger = Logger.getLogger(immaginiModel.class.getName());
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/EasyTravel");

		} catch (NamingException e) {
			logger.log(Level.WARNING, e.getMessage());
			
		}
	}
	
	private static final String TABLE_NAME_IMMAGINI = "Immagini";
	String CODICE ="Codice";
	
	public synchronized Collection<immaginiBean> immaginiPerPacchetto(String code) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<immaginiBean> immagini = new LinkedList<>();
		
		String selectSQL = "SELECT * FROM " + immaginiModel.TABLE_NAME_IMMAGINI + " WHERE Codice = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				immaginiBean bean = new immaginiBean();
				bean.setNome(rs.getString("Nome"));
				bean.setCodice(rs.getString(CODICE));
				immagini.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return immagini;
	}
	
	public synchronized Collection<immaginiBean> Copertine() throws SQLException{
		PreparedStatement ps = null;
		Collection<immaginiBean> immagini = new LinkedList<>();
		String sql = "SELECT * FROM " + immaginiModel.TABLE_NAME_IMMAGINI + " WHERE FlagCopertina = 1";
		try(Connection con = ds.getConnection())
		{
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				immaginiBean bean = new immaginiBean();
				bean.setNome(rs.getString("Nome"));
				bean.setCodice(rs.getString(CODICE));
				immagini.add(bean);
			}
		}
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		finally
		{
			if(ps != null)
			{
				ps.close();
			}
		}
		return immagini;
	}
	
	public synchronized immaginiBean immagineCopertina(String code) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		immaginiBean bean = new immaginiBean();
		
		String selectSQL = "SELECT * FROM " + immaginiModel.TABLE_NAME_IMMAGINI + " WHERE Codice = ? AND FlagCopertina=1";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNome(rs.getString("Nome"));
				bean.setCodice(rs.getString(CODICE));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
		return bean;
	}
}
