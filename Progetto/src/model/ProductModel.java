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

public class ProductModel {
	
	static Logger logger = Logger.getLogger(ProductModel.class.getName());
	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/easytravel");

		} catch (NamingException e) {
			logger.log(Level.WARNING, e.getMessage());
			
		}
	}
	
	private static final String TABLE_NAME_PACCHETTO = "Pacchetto";
	
	
	public synchronized Collection<PacchettoBean> stampaTutti() throws SQLException
	{
		
		PreparedStatement ps = null;
		
		Collection<PacchettoBean> pacchetti = new LinkedList<>();
		
		String sql = "SELECT * FROM " + ProductModel.TABLE_NAME_PACCHETTO + " WHERE FlagDisponibilità = 1";
		
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
				bean.setImmagine(rs.getString("Immagine"));
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
}
