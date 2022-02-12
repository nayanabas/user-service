package com.mypractice.user.controller;

import com.mypractice.user.VO.RestTemplateVO;
import com.mypractice.user.entity.User;
import com.mypractice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public RestTemplateVO findUserByUserId(@PathVariable Long userId){
        return userService.findUserByUserId(userId);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
