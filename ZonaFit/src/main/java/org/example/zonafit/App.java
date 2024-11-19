package org.example.zonafit;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Connection connection = new Connection();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        connection.setUserName(username);

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        connection.setPassword(password);

        if (connection.getConnection() != null) {
            System.out.println("Connected to the database");
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}
