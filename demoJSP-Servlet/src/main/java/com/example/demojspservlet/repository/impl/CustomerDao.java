package com.example.demojspservlet.repository.impl;

import com.example.demojspservlet.entity.Customer;
import com.example.demojspservlet.repository.ConnectionConfig;
import com.example.demojspservlet.repository.ICustomerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    private final String SELECT_ALL = "SELECT * FROM customer";
    private final String SELECT_BY_ID = "SELECT * FROM customer WHERE id = ?";
    private final String ADD = "INSERT INTO customer(name,gender,date_of_birth,id_card,phone_number,email,address)" +
            "VALUES (?,?,?,?,?,?,?)";
    private final String EDIT = "UPDATE customer SET name = ?, gender = ?, date_of_birth = ?, id_card = ?, phone_number = ?," +
            " email = ?, address = ? WHERE id = ?";
    private final String REMOVE = "UPDATE customer SET is_delete = 1 WHERE id =?";
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    private int rowUpdate = 0;

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                connection = ConnectionConfig.getConnection();
                preparedStatement = connection.prepareStatement(SELECT_ALL);
                resultSet = preparedStatement.executeQuery();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Boolean isDelete = resultSet.getBoolean("is_delete");
                customerList.add(new Customer(id, name, gender, dateOfBirth, idCard, phoneNumber, email, address, isDelete));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public boolean add(Customer customer) {
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(ADD);
            if (resultSet.next()) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setBoolean(2, customer.isGender());
                preparedStatement.setString(3, customer.getDateOfBirth());
                preparedStatement.setString(4, customer.getIdCard());
                preparedStatement.setString(5, customer.getPhoneNumber());
                preparedStatement.setString(6, customer.getEmail());
                preparedStatement.setString(7, customer.getAddress());
                rowUpdate = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return rowUpdate > 0;
    }

    @Override
    public boolean edit(int id, Customer customer) {
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement.setInt(1, id);
            preparedStatement = connection.prepareStatement(EDIT);
            if (resultSet.next()) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setBoolean(2, customer.isGender());
                preparedStatement.setString(3, customer.getDateOfBirth());
                preparedStatement.setString(4, customer.getIdCard());
                preparedStatement.setString(5, customer.getPhoneNumber());
                preparedStatement.setString(6, customer.getEmail());
                preparedStatement.setString(7, customer.getAddress());
                rowUpdate = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return rowUpdate > 0;
    }

    @Override
    public boolean remove(int id) {
        try{
            connection = ConnectionConfig.getConnection();
            preparedStatement.setInt(1,id);
            preparedStatement = connection.prepareStatement(REMOVE);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
