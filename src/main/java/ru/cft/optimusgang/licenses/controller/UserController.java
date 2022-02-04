package ru.cft.optimusgang.licenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.optimusgang.licenses.repository.model.entities.UserEntity;
import ru.cft.optimusgang.licenses.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserEntity user){
        userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id, @RequestBody UserEntity userEntity){
        try {
            userService.updateUser(id, userEntity);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
