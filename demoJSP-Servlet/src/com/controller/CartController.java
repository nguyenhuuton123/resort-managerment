package com.controller;

import com.entity.CartItems;
import com.repository.HomeRepository;
import com.service.HomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "cartServlet", value = "/cart")
public class CartController extends HttpServlet {

    private final HomeRepository homeRepository;

    private final HomeService homeService;

    public CartController() {
        homeService = new HomeService();
        homeRepository = new HomeRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<CartItems> cartItems;
        int size;
        try {
            cartItems = homeService.getCartLineList();
            size = cartItems.size();
            request.setAttribute("cartItems", cartItems);
            request.setAttribute("size", size);
            homeRepository.addToOrderline();
            RequestDispatcher read = request.getRequestDispatcher("/cart1.jsp");
            read.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String[] product_id = request.getParameterValues("product_id");
        String[] quantity = request.getParameterValues("quantity");

        try {
            homeService.updateQuantity(product_id, quantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<CartItems> cartItems;
        int totalPrice;

        try {
            cartItems = homeService.getCartLineList();
            totalPrice = homeService.totalPrice(cartItems);

            request.setAttribute("cartItems", cartItems);
            request.setAttribute("totalPrice", totalPrice);

            RequestDispatcher read = request.getRequestDispatcher("/bill1.jsp");
            read.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}