package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

public interface UserService {
    public int deleteUser(int uid);

    List<User> getUserList();

    int addUser(User user);

    public String getUpwdByUname(String uname);

    public String getRoleByUname(String uname);
}
