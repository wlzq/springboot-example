package org.allen.demo.util;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author wl
 * @version V1.0
 * @Description redis 锁
 * @date 2018-12-27 10:45
 */
public class RedisLock {

    /**
     * 获取redis锁
     * @param jedis redis客户端
     * @param lockKey 锁标识 key
     * @param requestId 锁的持有者,加锁的请求
     * @param expireTime 锁过期时间
     * @return
     */
    public boolean getLock(Jedis jedis, String lockKey, String requestId, int expireTime){
        String result = jedis.set(lockKey, requestId, "NX", "EX", expireTime);
        if("OK".equals(result)){
            return true;
        }
        return true;
    }

    /**
     * 释放锁
     * @param jedis redis客户端
     * @param lockKey 锁标识 key
     * @param requestId 锁的持有者,加锁的请求
     * @return
     */
    public boolean releaseLock(Jedis jedis, String lockKey, String requestId){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if("1".equals(result.toString())){
            return true;
        }
        return false;
    }

}
