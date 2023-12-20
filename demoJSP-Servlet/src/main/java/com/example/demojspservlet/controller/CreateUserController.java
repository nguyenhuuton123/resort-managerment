package com.example.demojspservlet.controller;

import com.example.demojspservlet.repository.UserRepository;
import com.example.demojspservlet.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createUserServlet", value = "/create-user")
public class CreateUserController extends HttpServlet {

    private final UserService userService;
    private final UserRepository userRepository = new UserRepository();

    public CreateUserController() {
        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/insert.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
//        String gender = request.getParameter("gender");
//        String date_of_birth = request.getParameter("date_of_birth");
//        String phone_number = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userRepository.insertUsername(username,password);
        response.sendRedirect(request.getContextPath() + "/home");

//        boolean isSuccessful;
//        try {
//            isSuccessful = userService.insert(name, gender, date_of_birth,phone_number,address,email);
//            if (isSuccessful) {
//                response.sendRedirect(request.getContextPath() + "/login");
//            } else {
//                getServletContext().getRequestDispatcher("/insert.jsp").forward(request, response);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}