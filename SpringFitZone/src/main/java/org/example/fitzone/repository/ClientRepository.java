package org.example.fitzone.repository;

import org.example.fitzone.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {}
