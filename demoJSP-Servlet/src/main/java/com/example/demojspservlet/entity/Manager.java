package com.example.demojspservlet.entity;

public class Manager extends User {
    public Manager(String username, String password) {
        super(username, password);
    }

    private static Manager manager;

    private Manager() {
        super();
        manager = new Manager("manager", "manager");
    }

    public static Manager getManager() {
        if (manager == null) {
            manager = new Manager("manager", "manager");
        }
        return manager;
    }
}
