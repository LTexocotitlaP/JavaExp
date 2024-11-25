package org.example.fitzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import org.example.fitzone.service.IClientService;

import javax.swing.*;

@SpringBootApplication
public class App {

    @Autowired
    private static IClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
