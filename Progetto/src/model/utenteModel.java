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

public class utenteModel {
	static Logger logger = Logger.getLogger(utenteModel.class.getName());
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
	
	private static final String TABLE_NAME_UTENTE = "Utente";
	
	public synchronized utenteBean stampaDati(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		utenteBean bean = new utenteBean();
		
		String selectSQL = "SELECT * FROM " + utenteModel.TABLE_NAME_UTENTE + " WHERE ID = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setEmail(rs.getString("Email"));
				bean.setPassword(rs.getString("Password"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setNumeroCivico(rs.getInt("NumeroCivico"));
				bean.setCap(rs.getInt("Cap"));
				bean.setIndirizzo(rs.getString("Indirizzo"));
				bean.setCitta(rs.getString("Citta"));
				bean.setProvincia(rs.getString("Provincia"));
				bean.setDataDiNascita(rs.getString("DataDiNascita"));
				bean.setNumeroTelefono(rs.getString("NumeroTelefono"));
				bean.setImmagine(rs.getString("Immagine"));
				bean.setFlagAmm(rs.getBoolean("FlagAmm"));
			}

		}finally {
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
