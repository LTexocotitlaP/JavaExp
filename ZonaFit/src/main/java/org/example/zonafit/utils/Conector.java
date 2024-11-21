package org.example.zonafit.utils;

import java.sql.*;

public class Conector {

    private static String database = "jdbc:mariadb://localhost:3306/zonafit";
    private static Connection conn;
    private static String username;
    private static String password;

    public Conector () {

    }

    public Connection getConn () {
        return this.conn;
    }

    public String getUserName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Connection setConn () {
        try {
            conn = DriverManager.getConnection(database, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
