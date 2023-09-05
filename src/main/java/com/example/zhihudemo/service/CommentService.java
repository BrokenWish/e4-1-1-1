package com.example.zhihudemo.service;

import com.example.zhihudemo.model.Comment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:52
 * @Name com.example.zhihudemo.service
 * @Projrct zhihudemo
 */
public interface CommentService {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    Date date = new Date();     //先获取一个Date对象
    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //创建一个格式化日期对象
    String format = simpleDateFormat.format(date);

    int add(Comment comment);

    List<Comment> findByRedId(int refId);

    List<Comment> query(int refId);
}
