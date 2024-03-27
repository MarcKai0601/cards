//package com.example.cards.TGNotify;
//
//import org.springframework.boot.SpringApplication; // 导入 Spring Boot 的 SpringApplication 类
//import org.springframework.boot.autoconfigure.SpringBootApplication; // 导入 Spring Boot 的 SpringBootApplication 注解
//import org.springframework.context.ConfigurableApplicationContext; // 导入 Spring 的 ConfigurableApplicationContext 类
//import org.telegram.abilitybots.api.bot.AbilityBot; // 导入 Telegram AbilityBot 类
//import org.telegram.telegrambots.meta.TelegramBotsApi; // 导入 Telegram Bots API 的 TelegramBotsApi 类
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException; // 导入 Telegram API 异常类
//import org.telegram.telegrambots.updatesreceivers.DefaultBotSession; // 导入 Telegram 默认的 Bot 会话类
//
//@SpringBootApplication // 这是一个 Spring Boot 注解，表示这是一个 Spring Boot 应用程序的主类
//public class TelegramBotApplication { // 声明了一个名为 TelegramBotApplication 的公共类
//
//    public static void main(String[] args) { // 这是 Java 程序的入口方法
//        ConfigurableApplicationContext ctx = SpringApplication.run(TelegramBotApplication.class, args); // 启动 Spring Boot 应用程序，并获取上下文对象
//
//        try { // 尝试执行以下代码块
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class); // 创建一个 TelegramBotsApi 实例，指定默认的 Bot 会话类
//            botsApi.registerBot(ctx.getBean("pizzaBot", AbilityBot.class)); // 注册一个 Telegram Bot，使用名为 "pizzaBot" 的 Spring Bean
//        } catch (TelegramApiException e) { // 捕获 Telegram API 异常
//            throw new RuntimeException(e); // 抛出运行时异常并包装原始异常
//        }
//    }
//}