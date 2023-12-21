package com.example.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payment")
public class confirm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerId = request.getParameter("customer_id");
        String employeeId = request.getParameter("employee_id");
        String arrivalDate = request.getParameter("arrival");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String deposit = request.getParameter("deposit");
        String departure = request.getParameter("departure");



        // Chuyển hướng người dùng đến trang xác nhận
        response.sendRedirect("confirm order.html");
    }
}
