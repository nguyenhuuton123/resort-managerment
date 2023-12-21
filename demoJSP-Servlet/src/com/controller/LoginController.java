package com.controller;

import com.entity.User;
import com.entity.Manager;
import com.repository.LoginRepository;
import com.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginController extends HttpServlet {

    private final LoginService loginService;
    private final LoginRepository loginRepository = new LoginRepository();

    public LoginController() {
        loginService = new LoginService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String usernameLogin = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isManager = false;

        if (usernameLogin.equals(Manager.getManager().getUsername()) && password.equals(Manager.getManager().getPassword())) {
            response.sendRedirect(request.getContextPath() + "success-notification.html");
            isManager = true;
        }

        User user;
        try {
            if (!isManager) {
                user = loginService.login(usernameLogin, password);
                int idEmployee = loginRepository.getIdEmployee(usernameLogin);
                if (user != null) {
                    request.getSession().setAttribute("usernameLogin", idEmployee);
                    request.getSession().setAttribute("user", user);
                    // response.sendRedirect(request.getContextPath() + "/home");
                    // request.setAttribute("message", "Đăng nhập thành công!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("success-notification1.html");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("message", "Đăng nhập thất bại!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                    dispatcher.forward(request, response);
                }

            }
        } catch (Exception e) {
            request.setAttribute("message", "Đăng nhập thất bại!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-notification.html");
            dispatcher.forward(request, response);
        }
    }
}