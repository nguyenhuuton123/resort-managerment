package com.example.controller;

import com.entity.Employee;
import com.example.service.EmployeeService;
import com.example.service.IEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employee-information-servlet", value = "/employee-register")
public class EmployeeInformationController extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee-edit-information.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String idCard = req.getParameter("idCard");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int positionId = Integer.parseInt(req.getParameter("positionId"));
        int educationId = Integer.parseInt(req.getParameter("educationId"));
        int divisionId = Integer.parseInt(req.getParameter("divisionId"));
        String username = req.getParameter("username");
        employeeService.addEmployeeInformation(new Employee(name,dateOfBirth,idCard,salary,phoneNumber,email,address,positionId,educationId
                ,divisionId,username));
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
