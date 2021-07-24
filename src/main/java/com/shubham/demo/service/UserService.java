package com.shubham.demo.service;

import com.shubham.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User save(User user);

    void deleteById(long id);

    User findUserById(long id);
}
