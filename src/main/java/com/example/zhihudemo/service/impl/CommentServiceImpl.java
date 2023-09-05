package com.example.zhihudemo.service.impl;

import com.example.zhihudemo.model.Comment;
import com.example.zhihudemo.service.CommentService;
import com.example.zhihudemo.util.MySQLUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:52
 * @Name com.example.zhihudemo.service.impl
 * @Projrct zhihudemo
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public int add(Comment comment) {
        try {
            Connection conn = MySQLUtils.getConn();
            PreparedStatement ps = null;


            //创建prepareStatement对象
            String sql = "insert into comment(user_id, red_id, content, parentId, gmt_created, gmt_modified) values (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            //执行sql语句
            ps.setInt(1, (int) comment.getUserId());
            ps.setInt(2, (int) comment.getRefId());
            ps.setString(3, comment.getContent());
            ps.setInt(4, (int) comment.getParentId());
            ps.setString(5, format);
            ps.setString(6, format);


            System.out.println(ps.execute());
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Comment> findByRedId(int refId) {
        List<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement ps = MySQLUtils.getConn().prepareStatement("SELECT * FROM comment WHERE ref_id = ?");
            ps.setInt(1, refId);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Comment comment = new Comment();

                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getLong("user_id"));
                comment.setRefId(rs.getLong("ref_id"));
                comment.setContent(rs.getString("content"));
                comment.setParentId(rs.getLong("parent_id"));

                String gmtCreated = rs.getString("gmt_created");
                comment.setGmtCreated(LocalDateTime.parse(gmtCreated, formatter));
                String gmtModified = rs.getString("gmt_modified");
                comment.setGmtModified(LocalDateTime.parse(gmtModified, formatter));

                comments.add(comment);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    @Override
    public List<Comment> query(int refId) {
        //查询所有的评论记录包含回复的
        List<Comment> comments = findByRedId(refId);

        //构建 map 结构
        Map<Long, Comment> commentMap = new HashMap<>();

        //初始化一个虚拟根节点，0 可以对应的是所有一级评论的父亲
        commentMap.put(0L, new Comment());

        //把所有的评论转换为 map 数据
        comments.forEach(comment -> commentMap.put((long) comment.getId(), comment));

        // 再次遍历评论数据
        comments.forEach(comment -> {

            //得到父评论
            Comment parent = commentMap.get(comment.getParentId());
            if (parent != null) {
                // 初始化 children 变量
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }

                // 在父评论里添加回复数据
                parent.getChildren().add(comment);
            }

        });

        // 得到所有的一级评论
        List<Comment> data = commentMap.get(0L).getChildren();

        return data;
    }
}

