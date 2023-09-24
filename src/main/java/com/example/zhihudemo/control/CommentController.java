package com.example.zhihudemo.control;

import com.example.zhihudemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-05-22:50
 * @Name com.example.zhihudemo.control
 * @Projrct zhihudemo
 */
@Controller
public class CommentController {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private CommentService commentService;

}
