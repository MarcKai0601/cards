package com.example.cards.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private static final Logger logger = LoggerFactory.getLogger(UniqueUsernameValidator.class);

    @Autowired
    private UserService userService;

    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userService == null) {
            logger.error("UserService is null. Injection failed.");
            return false;
        }
        return (userService.findUserByUsername(username) == null);
    }
}