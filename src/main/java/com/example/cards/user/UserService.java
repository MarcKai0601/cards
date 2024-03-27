package com.example.cards.user;

import com.example.cards.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

@Service
@Validated
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Validator validator;

    private final PasswordEncoder passwordEncoder; // 添加密碼加密器成員變量

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder(); // 初始化密碼加密器
    }

    public void addUser(UserModel user) {
        // 驗證 UserModel 對象
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserModel> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException(sb.toString(), violations);
        }

        // 檢查是否已存在相同的使用者名稱或電子郵件
        UserModel existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("使用者名稱已存在");
        }
        existingUser = userMapper.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("電子郵件已被使用");
        }

        // 使用 UserMapper 进行插入操作
        // 在这里对用户密码进行加密
//        String MD5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
//        user.setPassword(MD5Password); // 将加密后的密码设置回 UserModel 对象

        // 使用 BCryptPasswordEncoder 加密密碼
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userMapper.insertUser(user);
    }


//    public String login(UserModel user) {
//
//        return null;
//    }

}

