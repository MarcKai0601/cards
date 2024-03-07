package com.example.cards.user.mapper;

import com.example.cards.user.UserModel;

public interface UserMapper {

    UserModel getUserById(int id);

    void insertUser(UserModel user);

    UserModel findByEmail(String email);

    UserModel findByUsername(String username);

}
