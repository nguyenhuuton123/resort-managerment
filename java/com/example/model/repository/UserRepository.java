package com.example.model.repository;

import com.example.model.entity.User;
import com.example.model.repository.ConnectionConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public boolean insertUserByUserName(String name,String gender,String date_of_birth,String phone_number,String address,String email) {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "INSERT INTO user (name, gender, date_of_birth,phone_number,address,email) VALUES (?, ?,?, ?,?, ?)";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, date_of_birth);
            stmt.setString(4, phone_number);
            stmt.setString(5, address);
            stmt.setString(6, email);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("bug");
        }
        return false;
    }

    public List<String> getPhoneNumberList() {
        List<String> phoneNumberList = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT phone_number FROM customer";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                phoneNumberList.add(resultSet.getString("phone_number"));
            }

        } catch (Exception e) {
            System.out.println("bug");
        }
        return phoneNumberList;
    }

    public User deleteUserByUserName(String username) {
        User user = new User();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "DELETE FROM user WHERE username = ?";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("bug");
        }
        return user;
    }

    public User updateUserByUserName(String username,String password,long id) {
        User user = new User();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "UPDATE user SET username = ?, password = ? WHERE id = ?";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, String.valueOf(id));
            stmt.executeUpdate();


        } catch (Exception e) {
            System.out.println("bug");
        }
        return user;
    }

    public void insertUsername(String username,String password) {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "INSERT INTO user (user_name, password) VALUES (?, ?)";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("bug");
        }
    }
}
