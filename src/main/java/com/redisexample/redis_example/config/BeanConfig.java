package com.redisexample.redis_example.config;

import com.redisexample.redis_example.repository.UserRepositoryRedisImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserRepositoryRedisImpl userRepositoryImpl() {
        return new UserRepositoryRedisImpl();
    }


}
