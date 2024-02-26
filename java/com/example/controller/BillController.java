package com.example.controller;

import com.example.model.entity.Order;
import com.example.model.entity.OrderLine;
import com.example.model.repository.HomeRepository;
import com.example.model.service.HomeService;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "billServlet", value = "/bill")
public class BillController extends HttpServlet {

    private final HomeRepository homeRepository;

    private final HomeService homeService;

    public BillController() {
        homeService = new HomeService();
        homeRepository = new HomeRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<OrderLine> orderLines;
        try {
            orderLines = homeRepository.getOrderList();
            if (orderLines != null) {
                request.setAttribute("orderLines", orderLines);
                RequestDispatcher read = request.getRequestDispatcher("/history.jsp");
                read.forward(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            homeRepository.deleteCartlineList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String totalPriceIntoCart = request.getParameter("totalPrice");
        String user_id = request.getParameter("user_id");
        Order order;
        try {
            order = homeService.insertTotalPriceToCart(totalPriceIntoCart, user_id);
            if (order != null) {
                request.setAttribute("order", order);
                response.sendRedirect(request.getContextPath() + "/order-confirmation.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}