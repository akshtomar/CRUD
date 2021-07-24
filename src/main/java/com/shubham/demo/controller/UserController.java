package com.shubham.demo.controller;

import com.shubham.demo.entity.User;
import com.shubham.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private List<User> showAllUsers() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @GetMapping("/user/{id}")
    private User showUser(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/createUser")
    private User createUser(@RequestBody User user) {
        User theUser = userService.save(user);
        return theUser;
    }

    @DeleteMapping("/deleteUser/{id}")
    private void deleteUser(@PathVariable long id) {
        userService.deleteById(id);
    }

    @PutMapping("/updateUser")
    private User updatePost(@RequestBody User user) {
        User theUser = userService.findUserById(user.getId());
        theUser.setAge(user.getAge());
        theUser.setAddress(user.getAddress());
        theUser.setFirstName(user.getFirstName());
        theUser.setLastName(user.getLastName());
        return userService.save(theUser);
    }

}
