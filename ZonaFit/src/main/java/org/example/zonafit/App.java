package org.example.zonafit;

import java.util.Scanner;
import org.example.zonafit.dao.ClientDao;
import org.example.zonafit.interfaces.IClient;
import java.util.List;
import org.example.zonafit.models.Client;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        IClient clientDAO = new ClientDao();

        while(!exit) {
            try {
                int option = showMenu(input);
                exit = executeOptions(input, option, clientDAO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    private static int showMenu(Scanner input) {
        System.out.println("""
                *** ZonaFit (GYM)
                1. List all clients
                2. Search client by ID
                3. Create new client record
                4. Update client record by ID
                5. Delete client record by ID
                6. Exit 
                Choose one option:\s""");
        return Integer.parseInt(input.nextLine());
    }

    private static boolean executeOptions(Scanner input, int option, IClient clientDAO) {
        System.out.println();
        boolean exit = false;
        switch (option) {
            case 1 -> {
                List<Client> clients = clientDAO.getAll();
                clients.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Type the client ID");
                int clientId = Integer.parseInt(input.nextLine());
                Client clientById = new Client(clientId);
                boolean executed = clientDAO.getById(clientById);
                if (executed == true ) {
                    System.out.println(clientById);
                } else {
                    System.out.println("Not founded");
                }
            }
            case 3 -> {
                System.out.println("Type the client info");
                String clientName = input.nextLine();
                String clientLastName = input.nextLine();
                int clientMembership = Integer.parseInt(input.nextLine());
                Client clientAdded = new Client(clientName, clientLastName, clientMembership);
                boolean executed = clientDAO.add(clientAdded);
                if (executed == true ) {
                    System.out.println("the client was added");
                    System.out.println(clientAdded);
                } else {
                    System.out.println("Not added");
                }
            }
            case 4 -> {
                System.out.println("Type the client info to be updated");
                String clientName = input.nextLine();
                String clientLastName = input.nextLine();
                int clientMembership = Integer.parseInt(input.nextLine());
                System.out.println("Type the client id to be updated");
                int clientId = Integer.parseInt(input.nextLine());
                Client clientUpdated = new Client(clientId, clientName, clientLastName, clientMembership);
                boolean executed = clientDAO.update(clientUpdated);
                if (executed == true ) {
                    System.out.println("the client was added");
                    System.out.println(clientUpdated);
                } else {
                    System.out.println("Not added");
                }
            }
            case 5 -> {
                System.out.println("Type the client ID");
                int clientId = Integer.parseInt(input.nextLine());
                Client clientById = new Client(clientId);
                boolean executed = clientDAO.delete(clientById);
                if (executed == true ) {
                    System.out.println(clientById);
                } else {
                    System.out.println("Not founded");
                }
            }
            case 6 -> {
                exit = true;
            }
        }
        return exit;
    }
}
