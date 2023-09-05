package com.example.zhihudemo.service;

import com.example.zhihudemo.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:40
 * @Name com.example.zhihudemo.service
 * @Projrct zhihudemo
 */
public interface UserService {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    Date date = new Date();     //先获取一个Date对象
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //创建一个格式化日期对象
    String format = simpleDateFormat.format(date);

    int add(User user);
    User queryByPhone(String number);
}
