package io.n0sense.myexam.service.impl;

import io.n0sense.myexam.entity.User;
import io.n0sense.myexam.repository.UserMapper;
import io.n0sense.myexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return false;
        } else return user.getPassword().equals(password);
    }

    @Override
    public boolean register(String username, String password) {
        if (!userMapper.existsByUsername(username)) {
            userMapper.save(
                    User.builder()
                            .username(username)
                            .password(password)
                            .build()
            );
            return true;
        } else {
            return false;
        }
    }
}
