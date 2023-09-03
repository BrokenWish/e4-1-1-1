package com.example.zhihudemo.service;

import com.example.zhihudemo.model.Comment;

import java.time.format.DateTimeFormatter;
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
    int add(Comment comment);

    List<Comment> findByRedId(int refId);

    List<Comment> query(int refId);
}
