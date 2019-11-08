package com.qf.mapper;

import com.qf.pojo.User;

import java.util.List;

public interface UserMapper {
    public int deleteUser(int uid);

    List<User> getUserList();

    int addUser(User user);

    public String getUpwdByUname(String uname);

    public String getRoleByUname(String uname);
    //增加一条新数据
    //1111111
    public String getRoleByUname2(String upwd);

}
