package org.seating_arrangement_system.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
    protected Connection connection;
    private final static String url = "jdbc:mysql://localhost:3306/seating_arrangement_system";
    private final static String dbUser = "root";
    private final static String dbPassword = "";

    Dao() {
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
        }
        catch(SQLException se) {
            System.out.println("db connection failed!");
            se.printStackTrace();
        }
    }

    public void destroy() {
        try {
            connection.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
