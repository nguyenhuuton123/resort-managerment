package com.example.demojspservlet.controller;

import com.example.demojspservlet.entity.CartItems;
import com.example.demojspservlet.entity.OrderLine;
import com.example.demojspservlet.entity.Products;
import com.example.demojspservlet.service.HomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher req = request.getRequestDispatcher("index2.html");
        req.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}