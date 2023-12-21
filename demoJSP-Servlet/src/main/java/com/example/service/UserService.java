package com.example.service;

import com.entity.User;
import com.example.repository.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public boolean insert(String name, String gender, String date_of_birth, String phone_number, String address, String email) {
        if (!isPhoneNumberExit(phone_number)) {
            return userRepository.insertUserByUserName(name, gender, date_of_birth, phone_number, address, email);
        }
        return false;
    }

    public User delete(String username) {
        return userRepository.deleteUserByUserName(username);
    }

    public User update(String username, String password, long id) {
        return userRepository.updateUserByUserName(username, password, id);
    }

    public boolean isPhoneNumberExit(String phoneNumberOfUser) {
        List<String> phoneNumbers = userRepository.getPhoneNumberList();
        for (String phoneNumber : phoneNumbers) {
            if (phoneNumberOfUser.equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
