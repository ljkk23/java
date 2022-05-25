package com.example.rediscache.controller;

import com.example.rediscache.Service.UserService;
import com.example.rediscache.polo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("/test")
    public User Test(int id){
        System.out.println("id="+id);
        return userService.getUser(id);
    }
}
