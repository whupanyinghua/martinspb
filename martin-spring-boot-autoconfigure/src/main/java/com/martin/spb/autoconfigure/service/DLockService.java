package com.martin.spb.autoconfigure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * 类DLockService的实现描述的实现描述：基于redis、lua脚本的分布式锁
 * 锁删除里边带有key、value是在校验的时候，需要验证当前key存储的value是否是之前锁定的时候设置的值
 * 防止redis上边注册的key过期之后删掉其他线程的锁
 * 一般建议每次去锁的时候，value的值设置成随机的
 *
 * @author panyinghua 2020-8-10 13:47
 */
public class DLockService {

    private final static long DEFAULT_TIME_OUT = 10;
    private final static TimeUnit DEFAULT_TIME_UNIT = TimeUnit.SECONDS;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean lock(String key, String value) {
        return lock(key, value, DEFAULT_TIME_OUT, DEFAULT_TIME_UNIT);
    }

    public boolean lock(String key, String value, long timeOut, TimeUnit timeUnit) {
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(key, value, timeOut>=0?timeOut:DEFAULT_TIME_OUT, null != timeUnit?timeUnit:DEFAULT_TIME_UNIT);
        return null!=result?result:false;
    }

    public void unlock(String key, String value) {
        Long unlock = stringRedisTemplate.execute(DEL_LUA_SCRIPT, Collections.singletonList(key), value);
        System.out.println("unlock result from redis is :" + unlock);
    }


    /**
     * 根据传入的key、value，进行redis删除操作的lua脚本
     */
    private final static String DEL_REDIS_KEY_WITH_VALUE_LUA = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    /**
     * 直接静态化redisscript脚本对象，因为该对象在整个MDLock中是不变的，因此直接声明为final static类型，
     * 注意，一定要设置脚本的返回类别，否则程序执行会抛java.lang.IllegalStateException异常，可以支持的人会类型参见ReturnType类
     */
    private final static RedisScript<Long> DEL_LUA_SCRIPT = RedisScript.of(DEL_REDIS_KEY_WITH_VALUE_LUA, Long.class);
}
