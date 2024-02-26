package com.example.model.repository;

import com.example.model.entity.User;
import com.example.model.repository.ConnectionConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {
    public User getUserByUserName(String username) {
        User user = new User();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT * FROM User where user_name = ?";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println("bug");
        }
        return user;
    }

    public int getIdEmployee(String username) {
        int idEmployee = 0;
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT id FROM User join employee on employee.username = user.user_name where  user_name = ?";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                idEmployee = resultSet.getInt("id");
            }
        } catch (Exception e) {
            System.out.println("bug");
        }
        return idEmployee;
    }

}
