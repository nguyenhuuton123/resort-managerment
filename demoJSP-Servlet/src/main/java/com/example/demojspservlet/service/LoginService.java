package com.example.demojspservlet.service;

import com.example.demojspservlet.entity.User;
import com.example.demojspservlet.repository.LoginRepository;

public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(){
        loginRepository = new LoginRepository();
    }

    public User login(String username, String password) {

        User user = loginRepository.getUserByUserName(username);

        String pass = user.getPassword();

        if(pass.equals(password)){
            return user;
        }
        return null;
    }
}
