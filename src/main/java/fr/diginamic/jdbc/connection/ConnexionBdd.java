package fr.diginamic.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * A compléter avec l'utilisation de databa.properties
 * @author chris
 *
 */
public class ConnexionBdd 
{
	public static Connection getConnection() throws SQLException, ClassNotFoundException 
	{ 
		Class.forName("org.mariadb.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
		return connection;
	}
}
