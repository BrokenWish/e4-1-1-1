package com.example.zhihudemo.model;

import java.time.LocalDateTime;

/**
 * @author Broken wish
 * @coding utf-8
 * @create 2023-09-02-21:14
 * @Name com.example.zhihudemo.model
 * @Projrct zhihudemo
 */
public class User {
    private int id;
    private long userId;
    private String phoneAndEmail;
    private String pwd;
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

    public String getPhoneAndEmail() {
        return phoneAndEmail;
    }

    public void setPhoneAndEmail(String phoneAndEmail) {
        this.phoneAndEmail = phoneAndEmail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
