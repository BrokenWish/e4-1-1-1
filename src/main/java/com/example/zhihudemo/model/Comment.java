package com.example.zhihudemo.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:15
 * @Name com.example.zhihudemo.model
 * @Projrct zhihudemo
 */
public class Comment {
    private int id;
    private int userId;
    private int refId;
    private String content;
    private int parentId;
    private List<Comment> children;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParentId() {
        return parentId;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
