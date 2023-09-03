package com.example.zhihudemo.service;

import com.example.zhihudemo.model.User;

import java.time.format.DateTimeFormatter;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:40
 * @Name com.example.zhihudemo.service
 * @Projrct zhihudemo
 */
public interface UserService {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    int add(User user);

    User queryByPhone(String number);
}
