package org.example.fitzone;

import org.example.fitzone.model.Client;
import org.example.fitzone.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private IClientService clientService;

    private static final Logger log = LoggerFactory.getLogger(App.class);

    String nl = System.lineSeparator();

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App started");
        Boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while(!exit) {
            int option = showMenu(scanner);
            log.info(nl);
            exit = executeOptions(scanner, option);
            log.info("Option selected: " + option);
        }
    }

    public int showMenu(Scanner scanner) {
        log.info("""
            Select an option:
            1. Show all clients
            2. Show client by id
            3. Add client
            4. Delete client
            5. Update client 
            6. Exit
            Choose an option:\s
            """);
        return scanner.nextInt();
    }

    public boolean executeOptions (Scanner scanner, int option) {
        boolean exit = false;
        switch(option) {
            case 1 -> {
                log.info(nl + "Showing all clients");
                List<Client> clients = clientService.findAllClients();
                clients.forEach(client -> log.info(client.toString() +nl));
                return false;
            }
            case 2 -> {
                log.info("Showing client by id");
                log.info("Type the client ID");
                Integer clientId = scanner.nextInt();
                try {
                    Client client = clientService.findClientById(clientId);
                    log.info(client.toString());
                } catch (Exception e) {
                    log.error("Error: " + e.getMessage());
                    return false;
                }
                return false;
            }
            case 3 -> {
                log.info("Adding new client");
                log.info("Type the client name");
                String name = scanner.next();
                log.info("Type the client lastname");
                String lastname = scanner.next();
                log.info("Type the client membership");
                Integer membership = scanner.nextInt();
                Client client = new Client();
                client.setName(name);
                client.setLastname(lastname);
                client.setMembership(membership);
                try {
                    clientService.saveClient(client);
                } catch (Exception e) {
                    log.error("Error: " + e.getMessage());
                    return false;
                }
                return false;
            }
            case 4 -> {
                log.info("Deleting client");
                log.info("Type the client ID");
                Integer clientId = scanner.nextInt();
                try {
                    clientService.deleteClientById(clientId);
                } catch (Exception e) {
                    log.error("Error: " + e.getMessage());
                    return false;
                }
                return false;
            }
            case 5 -> {
                log.info("Updating client");
                log.info("Type the client ID");
                Integer clientId = scanner.nextInt();
                Client client = clientService.findClientById(clientId);
                log.info("Type the client name");
                String name = scanner.next();
                log.info("Type the client lastname");
                String lastname = scanner.next();
                log.info("Type the client membership");
                Integer membership = scanner.nextInt();
                client.setName(name);
                client.setLastname(lastname);
                client.setMembership(membership);
                try {
                    clientService.saveClient(client);
                } catch (Exception e) {
                    log.error("Error: " + e.getMessage());
                    return false;
                }
                return false;
            }
            case 6 -> {
                log.info("Exiting");
                return true;
            }
            default -> log.info("Invalid option");
        }
        return exit;
    }
}
