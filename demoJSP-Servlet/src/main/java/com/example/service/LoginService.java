package com.example.service;

import com.entity.User;
import com.example.repository.repository.LoginRepository;

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
