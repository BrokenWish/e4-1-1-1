package com.example.zhihudemo.control;

import com.example.zhihudemo.service.CommentService;
import com.example.zhihudemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/zhihu/index.html")
    public String index(Model model) {
        return "index.html";
    }

    @GetMapping("/zhihu/other.html")
    public String other(Model model) {
        return "other.html";
    }

    @GetMapping("/zhihu/login.html")
    public String login(Model model) {
        return "login.html";
    }



//    @PostMapping("/zhihu/userLogin")
//    public String saveBook(User user) {
//        if (user == null) {
//            return "login.html";
//        }
//
//        User user1 = userService.queryByPhone(user.getPhoneAndEmail());
//
//        if (user1 == null){
//
//        }
//            return "saveBookSuccess";
//    }
}

