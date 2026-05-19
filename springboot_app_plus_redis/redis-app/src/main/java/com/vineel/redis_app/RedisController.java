package com.vineel.redis_app;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private final StringRedisTemplate redisTemplate;

    public RedisController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/save")
    public String save() {

        redisTemplate.opsForValue()
                .set("name", "vineel");

        return "Saved in Redis";
    }

    @GetMapping("/get")
    public String get() {

        return redisTemplate.opsForValue()
                .get("name");
    }
}