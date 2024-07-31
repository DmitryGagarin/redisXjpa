package com.redisexample.redis_example.service;

import com.redisexample.redis_example.model.User;
import com.redisexample.redis_example.repository.UserRepositoryJpa;
import com.redisexample.redis_example.repository.UserRepositoryRedisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  {

    @Autowired
    private UserRepositoryRedisImpl userRepRedis;

    @Autowired
    private UserRepositoryJpa userRepJpa;

    public boolean saveUser(User user) {
        User savedUser = userRepJpa.save(user);
        return userRepRedis.saveUser(savedUser);
    }

    public List<Object> fetchAllUsers() {
        return userRepRedis.fetchAllUsers();
    }

    public User fetchUserById(Long id) {
        User user = userRepRedis.fetchUserById(id);
        if (user == null) {
            Optional<User> userFromDb = userRepJpa.findById(id);
            if (userFromDb.isPresent()) {
                user = userFromDb.get();
                userRepRedis.saveUser(user);
            }
        }
        return user;
    }
}
