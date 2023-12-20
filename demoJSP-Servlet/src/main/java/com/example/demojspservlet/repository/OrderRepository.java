package com.example.demojspservlet.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
