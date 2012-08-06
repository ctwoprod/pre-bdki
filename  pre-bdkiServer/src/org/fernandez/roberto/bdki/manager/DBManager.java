package org.fernandez.roberto.bdki.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public static Connection getConnection(String _host, String _database,
			String _user, String _password) throws ClassNotFoundException,
			SQLException {
		Class.forName(JDBC_DRIVER);
		return (DriverManager.getConnection("jdbc:mysql://" + _host + ":3306/"
				+ _database, _user, _password));
	}

}
