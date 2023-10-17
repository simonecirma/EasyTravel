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

import model.PacchettoBean;
import model.pacchettoModel;

public class pacchettoModel {
	
	static Logger logger = Logger.getLogger(pacchettoModel.class.getName());
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
	
	private static final String TABLE_NAME_PACCHETTO = "Pacchetto";
	
	
	public synchronized Collection<PacchettoBean> stampaTutti() throws SQLException
	{
		
		PreparedStatement ps = null;
		Collection<PacchettoBean> pacchetti = new LinkedList<>();
		String sql = "SELECT * FROM " + pacchettoModel.TABLE_NAME_PACCHETTO + " WHERE FlagDisponibilità = 1";
		try(Connection con = ds.getConnection())
		{
			
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				PacchettoBean bean = new PacchettoBean();
				bean.setCodSeriale(rs.getString("CodSeriale"));
				bean.setNome(rs.getString("Nome"));
				bean.setPrezzo(rs.getFloat("Prezzo"));
				bean.setDescrizioneRidotta(rs.getString("DescrizioneRidotta"));
				pacchetti.add(bean);
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
		return pacchetti;
	}
	
	public synchronized PacchettoBean ricercaPerCodice(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		PacchettoBean bean = new PacchettoBean();

		String selectSQL = "SELECT * FROM " + pacchettoModel.TABLE_NAME_PACCHETTO + " WHERE CodSeriale = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCodSeriale(rs.getString("CodSeriale"));
				bean.setNome(rs.getString("Nome"));
				bean.setDescrizioneRidotta(rs.getString("DescrizioneRidotta"));
				bean.setDescrizioneRidotta(rs.getString("Descrizione"));
				bean.setPrezzo(rs.getFloat("Prezzo"));
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
	
	public synchronized boolean cancellaPacchetto(String code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + pacchettoModel.TABLE_NAME_PACCHETTO + " WHERE CodSeriale = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, code);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	public synchronized void salva(PacchettoBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + pacchettoModel.TABLE_NAME_PACCHETTO
				+ " (Nome, DescrizioneRidotta, Prezzo, Immagine) VALUES (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setString(2, product.getDescrizioneRidotta());
			preparedStatement.setFloat(3, product.getPrezzo());

			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
}

