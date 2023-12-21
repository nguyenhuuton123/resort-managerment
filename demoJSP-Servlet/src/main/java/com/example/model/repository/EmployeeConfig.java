package com.example.model.repository;

import com.example.model.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeConfig implements IEmployeeDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int rowUpdate = 0;
    private final String SELECT_ALL = "SELECT * FROM employee";
    private final String SELECT_BY_ID = "SELECT * FROM employee WHERE id = ?";
    private final String ADD_EMPLOYEE_INFORMATION = "INSERT INTO employee(name,date_of_birth,id_card,salary,phone_number," +
            "email,address,position_id,education_degree_id,division_id,username) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final String EDIT_EMPLOYEE_INFORMATION = "UPDATE employee SET name = ?, date_of_birth = ?, id_card = ?, salary = ?," +
            " phone_number = ?, email = ?, address = ?, position_id = ?, education_degree_id = ?, division_id = ? username = ?" +
            " WHERE id = ?";
    private final String DELETE_EMPLOYEE = "UPDATE employee SET is_delete = 1 WHERE id = ?";
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        connection = ConnectionConfig.getConnection();
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard  = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId =resultSet.getInt("division_id");
                String username = resultSet.getString("user_name");
                boolean isDelete = resultSet.getBoolean("is_delete");
                employeeList.add(new Employee(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,positionId,educationDegreeId,
                        divisionId,username,isDelete));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return employeeList;
    }

    @Override
    public Employee findById(int key) {
        connection = ConnectionConfig.getConnection();
        try {
            preparedStatement.setInt(1,key);
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard  = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId =resultSet.getInt("division_id");
                String username = resultSet.getString("user_name");
                boolean isDelete = resultSet.getBoolean("is_delete");
                return new Employee(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,positionId,educationDegreeId,
                        divisionId,username,isDelete);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(resultSet != null) {
                    resultSet.close();
                }
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean addEmployeeInformation(Employee employee) {
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_INFORMATION);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationId());
            preparedStatement.setInt(10,employee.getDivisionId());
            preparedStatement.setString(11,employee.getUsername());
            rowUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return rowUpdate > 0 ;
    }

    @Override
    public boolean editEmployeeInformation(int id, Employee employee) {
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement.setInt(1,id);
            preparedStatement = connection.prepareStatement(EDIT_EMPLOYEE_INFORMATION);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationId());
            preparedStatement.setInt(10,employee.getDivisionId());
            preparedStatement.setString(11,employee.getUsername());
            rowUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return rowUpdate > 0 ;
    }

    @Override
    public boolean removeEmployeeInformation(int id) {
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            rowUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return rowUpdate > 0 ;
    }
}
