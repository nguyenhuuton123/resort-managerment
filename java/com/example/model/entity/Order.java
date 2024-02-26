package com.example.model.entity;

public class Order {

    private int id;

    private int toTalPrice;

    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToTalPrice() {
        return toTalPrice;
    }

    public void setToTalPrice(int toTalPrice) {
        this.toTalPrice = toTalPrice;
    }

}
