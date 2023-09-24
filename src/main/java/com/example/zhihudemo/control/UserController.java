package com.example.zhihudemo.control;

import com.example.zhihudemo.model.Result;
import com.example.zhihudemo.model.User;
import com.example.zhihudemo.service.UserService;
import com.example.zhihudemo.util.SnowFlakeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserService userService;

    @GetMapping ("/zhihu/index.html")
    public String index(Model model) {
        return "index.html";
    }

    @PostMapping("/zhihu/login.html")
    public String indexs(User user, Model model) {
        Result<User> result = new Result<>();
        User user1 = userService.queryByPhone(user.getPhoneAndEmail());

//        System.out.println("9999999999999999999999");
//        System.out.println(user.getPhoneAndEmail());
//        System.out.println(user.getPwd());

        if (user1.getPhoneAndEmail() == null){
//            System.out.println("创建");

            user.setUserId(SnowFlakeUtil.getSnowFlakeId());
            user.setPhoneAndEmail(user.getPhoneAndEmail());
            user.setPwd(user.getPwd());
            String date = formatter.format(LocalDateTime.now());

            user.setGmtCreated(LocalDateTime.parse(date, formatter));
            user.setGmtModified(LocalDateTime.parse(date, formatter));

            userService.add(user);

            result.setData(user);
            result.setSuccess(true);
            result.setMessage("用户名不存在，已帮助注册");
            model.addAttribute("message", "用户名不存在，已帮助注册");
            return "login.html";
        }

        if (user.getPwd().equals(user1.getPwd())){
//            System.out.println("成功");
            result.setData(user);
            result.setSuccess(true);
            result.setMessage("登陆成功");
            model.addAttribute("message", "登陆成功");
            return "login.html";
        }else{
            result.setMessage("密码错误");
//            System.out.println("失败");
            model.addAttribute("message", "密码错误");
            return "index.html";
        }

    }

    @GetMapping("/zhihu/other.html")
    public String other(Model model) {
        return "other.html";
    }

}

