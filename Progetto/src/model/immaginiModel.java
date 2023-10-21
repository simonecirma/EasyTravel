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
				bean.setCodice(rs.getString("Codice"));
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
}
