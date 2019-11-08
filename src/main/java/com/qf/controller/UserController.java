package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityManager securityManager;
    @RequestMapping("delete")
    public String dele(int uid){
        userService.deleteUser(uid);
        return "redirect:index";
    }

    @RequestMapping("index")
    public String getList(@RequestParam(defaultValue = "1")int pageNum, Model model){
        PageHelper.startPage(pageNum, 3);
        List<User> userList = userService.getUserList();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }
    @RequestMapping("add")
    public String addUser(){
        return "addUser";
    }
    @RequestMapping("addUser")
    public String add(User user){
        System.out.println("11111111111");
        int i = userService.addUser(user);
        return "redirect:index";
    }
    @RequestMapping("loginPage")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("login")
    public String login(String uname,String upwd){
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(uname,upwd);
        try {
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                return "redirect:index";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:loginPage";
    }
    @RequestMapping("unauth")
    public String ua(){
        return "unauth";
    }
}
