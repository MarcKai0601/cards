package com.example.cards.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserModel {

    private int id;

    @NotBlank(message = "帳號不可為空")
    private String username;

    @Email(message = "信箱格式錯誤")
    @NotBlank(message = "信箱不可為空")
    private String email;

    @Size(min = 8, message = "密碼不可少於8位")
    @NotBlank(message = "密碼不可為空")
    private String password;

}