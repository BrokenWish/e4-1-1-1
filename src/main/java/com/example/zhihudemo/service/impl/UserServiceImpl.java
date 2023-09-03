package com.example.zhihudemo.service.impl;

import com.example.zhihudemo.model.User;
import com.example.zhihudemo.service.UserService;
import com.example.zhihudemo.util.MySQLUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:40
 * @Name com.example.zhihudemo.service.impl
 * @Projrct zhihudemo
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int add(User user) {
        try {
            Connection conn = MySQLUtils.getConn();
            PreparedStatement ps = null;


            //创建prepareStatement对象
            String sql = "insert into user(user_id, phoneAndEmail, pwd, gmt_created, gmt_modified) values (?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            ps.setInt(1, user.getUserId());
            ps.setString(2,user.getPhoneAndEmail());
            ps.setString(3,user.getPwd());
            ps.setString(4, String.valueOf(user.getGmtCreated()));
            ps.setString(5, String.valueOf(user.getGmtModified()));


            System.out.println(ps.execute());
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public User queryByPhone(String number) {
        User user = new User();

        try {
            PreparedStatement ps = MySQLUtils.getConn().prepareStatement("SELECT * FROM user WHERE phoneAndEmail = ?");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUserId(rs.getInt("user_id"));
                user.setPhoneAndEmail(rs.getString("phoneAndEmail"));
                user.setPwd(rs.getString("pwd"));

                String gmtCreated = rs.getString("gmt_created");
                user.setGmtCreated(LocalDateTime.parse(gmtCreated, formatter));
                String gmtModified = rs.getString("gmt_modified");
                user.setGmtModified(LocalDateTime.parse(gmtModified, formatter));

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
