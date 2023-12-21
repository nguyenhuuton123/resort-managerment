package com.example.service;

import com.entity.CartItems;
import com.entity.Order;
import com.entity.OrderLine;
import com.entity.Products;
import com.example.repository.repository.HomeRepository;

import java.sql.SQLException;
import java.util.List;

public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService() {
        homeRepository = new HomeRepository();
    }

    public Integer getCartId(Integer user_id) throws SQLException {
        return homeRepository.selectCartId(user_id);
    }

    public void insertUser_idTOCart(Integer user_id) {
         homeRepository.addUserIdToCart(user_id);
    }

    public Order insertTotalPriceToCart(String totalPriceIntoCart, String user_id) {
        return homeRepository.addTotalPriceToCart(totalPriceIntoCart,user_id);
    }

    public OrderLine addCartLineToCart(Integer cart_id, String product_id,
                                       String quantity, String size_id, String topping_ids) {
        return homeRepository.addToCart(cart_id, product_id, quantity, size_id, topping_ids);
    }

    public List<Products> getProductList() {
        return homeRepository.getProductList();
    }

    public List<CartItems> getCartLineList() {
        return homeRepository.getCartLineList();
    }

    public void updateQuantity(String[] quantity,String[] product_id) throws SQLException {
        for (int i=0;i< product_id.length && i< quantity.length;i++){
         homeRepository.updateQuantity(quantity[i],product_id[i]);}
    }

    public int totalPrice(List<CartItems> cartItems) {
        int price;

        int totalPrice = 0;

        for (CartItems order : cartItems) {
            price = (order.getSubToTal());
            totalPrice += price;
        }
        return totalPrice;
    }
}