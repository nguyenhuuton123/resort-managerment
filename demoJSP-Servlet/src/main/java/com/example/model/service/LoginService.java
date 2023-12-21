package com.example.model.service;

import com.example.model.entity.User;
import com.example.model.repository.LoginRepository;

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
