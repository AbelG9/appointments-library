package com.codigo.appointmentslibrary.config;

import com.codigo.appointmentslibrary.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final StringRedisTemplate stringRedisTemplate;

    public RedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void saveInCache(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        stringRedisTemplate.expire(key, Constants.TIME_EXPIRATION_REDIS, TimeUnit.MINUTES);
    }

    public String getValueFromCache(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void deleteFromCache(String key) {
        stringRedisTemplate.delete(key);
    }
}
