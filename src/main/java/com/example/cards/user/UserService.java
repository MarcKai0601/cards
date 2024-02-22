package com.example.cards.user;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.Validator;
//import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Integer addUser(UserModel user) {
        UserModel newUser = userRepository.save(user);
        return newUser.getId();
    }
}