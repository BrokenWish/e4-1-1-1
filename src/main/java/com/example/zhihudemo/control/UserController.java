package com.example.zhihudemo.control;

import com.example.zhihudemo.service.CommentService;
import com.example.zhihudemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-03-15:42
 * @Name com.example.zhihudemo.control
 * @Projrct zhihudemo
 */
@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/zhihu/index")
    public String index(){
        return "index.html";
    }
}
