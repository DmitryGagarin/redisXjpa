package com.redisexample.redis_example.repository;

import com.redisexample.redis_example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class UserRepositoryRedisImpl implements UserRepositoryRedis {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "User";

    @Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> fetchAllUsers() {
        List<Object> users;
        users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    @Override
    public User fetchUserById(Long id) {
        User user;
        user = (User) redisTemplate.opsForHash().get(KEY, id.toString());
        return user;
    }
}
