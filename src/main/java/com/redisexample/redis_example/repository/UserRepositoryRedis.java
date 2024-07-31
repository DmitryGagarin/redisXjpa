package com.redisexample.redis_example.repository;

import com.redisexample.redis_example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryRedis {
    boolean saveUser(User user);

    List<Object> fetchAllUsers();

    User fetchUserById(Long id);

}
