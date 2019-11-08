package com.qf.pojo;

public class User {
    private int uid;
    private String uname;
    private String upwd;
    private String role;

    public User(int uid, String uname, String upwd, String role) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.role = role;
    }

    public User(String uname, String upwd, String role) {
        this.uname = uname;
        this.upwd = upwd;
        this.role = role;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
