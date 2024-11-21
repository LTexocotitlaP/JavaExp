package org.example.zonafit.dao;

import java.util.List;

import org.example.zonafit.interfaces.IClient;
import org.example.zonafit.models.Client;

import java.sql.*;
import java.util.ArrayList;

import static org.example.zonafit.utils.Conector.setConn;

public class ClientDao implements IClient {

    @Override
    public List<Client> getAll() {
        
        List<Client> clients = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement ps = null;

        Connection conn = setConn();

        String sql = "SELECT * FROM clients";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Client client = new Client();

                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setLastName(rs.getString("lastname"));
                client.setMembership(rs.getInt("membership"));

                clients.add(client);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return clients;

    }

    @Override
    public boolean getById(Client client) {

        ResultSet rs = null;
        PreparedStatement ps = null;

        Connection conn = setConn();

        String sql = "SELECT * FROM clients WHERE id = ?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setInt(1, client.getId());
            rs = ps.executeQuery();

            if (rs.next()) {

                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setLastName(rs.getString("lastname"));
                client.setMembership(rs.getInt("membership"));

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean add(Client client) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = setConn();

        String sql = "INSERT INTO clients (name, lastname, membership) VALUES (?, ?, ?)";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getMembership());

            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean update(Client client) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = setConn();

        String sql = "UPDATE clients SET name=?, lastname=?, membership=? WHERE id=?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, client.getMembership());
            ps.setInt(4, client.getId());

            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Client client) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = setConn();

        String sql = "DELETE FROM clients WHERE id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, client.getId());

            if (ps.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
