package com.controller;

import com.entity.User;
import com.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateController", value = "/update")
public class UpdateController extends HttpServlet {

    private final UserService userService;

    public UpdateController() {
        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/update.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        User user;
        try {
            user = userService.update(username, password, Long.parseLong(id));
            if (user != null) {
                request.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home.jsp");
            } else {
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}