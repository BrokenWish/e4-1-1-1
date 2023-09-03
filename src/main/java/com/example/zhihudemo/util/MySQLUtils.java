package com.example.zhihudemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:42
 * @Name com.example.zhihudemo.util
 * @Projrct zhihudemo
 */
public class MySQLUtils {

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        //mysql用户名
        String userName = "brokenwish";
        //mysql密码
        String password = "1256338Mysql";
        //数据库URL
        String url = "jdbc:mysql://rm-uf6tp8qmdd70a844bto.mysql.rds.aliyuncs.com/zhihudb?serverTimezone=GMT%2B8";

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
}
