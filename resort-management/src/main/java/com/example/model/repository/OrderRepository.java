package com.example.model.repository;



import com.example.model.entity.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public void insertOrder(String customerPhone,int employeeId,String arrivalDate,String departureDate,double deposit, int facility_id) {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "INSERT INTO contract (start_date, end_date, deposit, employee_id, customer_id, facility_id)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, arrivalDate);
            stmt.setString(2, departureDate);
            stmt.setDouble(3, deposit);
            stmt.setInt(4, employeeId);
            stmt.setString(5, customerPhone);
            stmt.setInt(6, facility_id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("bug");
        }
    }

    public List<Contract> getContractList() {
        List<Contract> contractList = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT * FROM contract";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Contract contracts = new Contract();
                contracts.setDeposit(resultSet.getInt("deposit"));
                contracts.setId(resultSet.getInt("id"));
                contracts.setEmployeeId(resultSet.getInt("employee_id"));
                contracts.setEndDate(resultSet.getString("end_date"));
                contracts.setStartDate(resultSet.getString("start_date"));
                contracts.setCustomerPhone(resultSet.getInt("customer_id"));
                contractList.add(contracts);
            }

        } catch (Exception e) {
            System.out.println("bug");
        }
        return contractList;
    }
}
