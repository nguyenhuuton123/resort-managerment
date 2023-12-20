package com.example.demojspservlet.controller;

import com.example.demojspservlet.entity.Employee;
import com.example.demojspservlet.service.EmployeeService;
import com.example.demojspservlet.service.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employee-information-servlet", value = "/employee-information")
public class EmployeeInformationController extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/employee/register.jsp").forward(req,resp);
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
        req.setAttribute("successful message", "SignUp successfully");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
