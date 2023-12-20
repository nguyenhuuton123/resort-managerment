package com.example.demojspservlet.controller;

import com.example.demojspservlet.entity.CartItems;
import com.example.demojspservlet.entity.OrderLine;
import com.example.demojspservlet.entity.Products;
import com.example.demojspservlet.service.HomeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeController extends HttpServlet {

    private final HomeService homeService;

    public HomeController() {
        homeService = new HomeService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<Products> products;
        List<CartItems> cartItems;
        int size;
        try {
            products = homeService.getProductList();
            cartItems = homeService.getCartLineList();
            size = cartItems.size();
            if (products != null) {
                request.setAttribute("products", products);
                request.setAttribute("size", size);
                RequestDispatcher req = request.getRequestDispatcher("index1.html");
                req.forward(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String product_id = request.getParameter("product_id");
        String quantity = request.getParameter("quantity");
        String size_id = request.getParameter("size_id");
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));
        String[] toppingArrIds = request.getParameterValues("topping_ids");
        String topping_ids = Arrays.toString(toppingArrIds);
        Integer cart_id;
        try {
            cart_id = homeService.getCartId(user_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        OrderLine orderLine;
        try {
            orderLine = homeService.addCartLineToCart(cart_id, product_id, quantity, size_id, topping_ids);
            if (orderLine != null) {
                request.setAttribute("orderLine", orderLine);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}