package com.example.controller;

import com.example.model.entity.User;
import com.example.model.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteController extends HttpServlet {
    private final UserService userService;

    public DeleteController() {
        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/delete.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");

        User user;
        try {
            user = userService.delete(username);
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
