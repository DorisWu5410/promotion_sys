package com.example.promotion.redis.lock;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import com.example.promotion.redis.service.RedisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisDistributionLock extends AbstractDistributionLock{

    private final RedisService redisService;

    private final String key;

    private final String value;

    private static final DefaultRedisScript<Long> redisScript;

    private static ApplicationContext applicationContext;

    
    static {
        redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("unlock.lua")));
        redisScript.setResultType(Long.class);
    }

    /**
     * @param redisService   redis
     * @param key            key of lock
     * @param survivalMillis max survival time of lock
     */

    public RedisDistributionLock(RedisService redisService, String key, long survivalMillis){
        // call another constructor
        this(redisService, key);
        this.survivalMillis = survivalMillis;
    }

    /**
     * @param redisService redis
     * @param key  key of lock
     */
    public RedisDistributionLock(RedisService redisService, String key){
        this.redisService = redisService;
        this.key = key;
        this.value = UUID.randomUUID().toString().replace("-", "");
    }

    /** 
     * @param key  key of lock
     */
    public RedisDistributionLock(String key){
        this(applicationContext.getBean(RedisService.class), key);
    }

    @Override
    public boolean tryLock(){
        boolean lockResult = redisService.setNX(key, value, survivalMillis, TimeUnit.MILLISECONDS);
        if(lockResult) {
            isLock.set(true);
        }
        return lockResult;
    }

    @Override
    public void unlock() {
        Long result;
        try{
            // try excuting unlock.lua
            result = redisService.execute(redisScript, List.of(key), List.of(value));
        } catch(Exception e){
            String msg = "unlock redis key failed, executing unlock scripts failed, key=" + key + ", expectedValue=" + value;
            throw new IllegalStateException(msg, e);
        }

        if(result == null){
            String msg = "unlock redis key failed, unlock scripts' result is null, key=" + key + ", expectedValue=" + value;
            throw new IllegalStateException(msg);
        }
        if (result != 1) {
            String msg = "unlock redis key failed, unlock scripts' result not 1, result=" + result + ", key=" + key + ", expectedValue=" + value;
            throw new IllegalStateException(msg);
        }
        isLock.set(false);
    }

}
