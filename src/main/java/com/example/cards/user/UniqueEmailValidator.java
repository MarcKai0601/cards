package com.example.cards.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private static final Logger logger = LoggerFactory.getLogger(UniqueEmailValidator.class);

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userService == null) {
            logger.error("UserService is null. Injection failed.");
            return false;
        } else {
            logger.info("UserService is successfully injected.");
            // Your validation logic here
            return true;
        }
    }
}