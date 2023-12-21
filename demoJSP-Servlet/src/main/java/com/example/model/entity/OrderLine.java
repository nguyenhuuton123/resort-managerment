package com.example.model.entity;

public class OrderLine {

    private int topping_ids;

    private int size_id;

    private int product_id;

    private int quantity;

    private  int order_id;

    public int getTopping_ids() {
        return topping_ids;
    }

    public void setTopping_ids(int topping_ids) {
        this.topping_ids = topping_ids;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}

