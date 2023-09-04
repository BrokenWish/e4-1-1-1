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
    private long userId;
    private long refId;
    private String content;
    private long parentId;
    private List<Comment> children;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRefId() {
        return refId;
    }

    public void setRefId(long refId) {
        this.refId = refId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
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
