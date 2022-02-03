package ru.cft.yellowrubberduck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.yellowrubberduck.repository.model.UserEntity;
import ru.cft.yellowrubberduck.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
}
