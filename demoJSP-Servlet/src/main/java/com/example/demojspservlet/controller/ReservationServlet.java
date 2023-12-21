package com.example.demojspservlet.controller;

import com.example.demojspservlet.repository.OrderRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    OrderRepository orderRepository = new OrderRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerPhone = request.getParameter("phone_number");
        int employeeId = Integer.parseInt((request.getParameter("employee_id")));
        String arrivalDate = request.getParameter("arrival");
        String departureDate = request.getParameter("departure");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        int facility_id = Integer.parseInt(request.getParameter("facility_id"));
        orderRepository.insertOrder(customerPhone,employeeId,arrivalDate,departureDate,deposit,facility_id);
        response.sendRedirect("confirmation.html");
    }
}
