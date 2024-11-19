package org.example.zonafit;

public class Connection {

    java.sql.Connection conn;
    String url = "jdbc:mariadb://localhost:3306/zonafit";
    String username;
    String password;

    public Connection() {

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

    public java.sql.Connection getConnection() {
        try {
            conn = java.sql.DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
