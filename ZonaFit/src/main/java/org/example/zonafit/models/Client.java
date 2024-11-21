package org.example.zonafit.models;

import java.util.Objects;

public class Client {

    private int id;
    private String name;
    private String lastName;
    private int membership;

    public Client () {

    }

    public Client (int id, String name, String lastName, int membership) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.membership = membership;
    }

    public Client (String name, String lastName, int membership) {
        this.name = name;
        this.lastName = lastName;
        this.membership = membership;
    }

    public Client (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMembership() {
        return membership;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMembership(int membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", membership='" + membership + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client client = (Client) obj;
            return this.id == client.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, membership);
    }

}
