package com.suning.redis.util;

import com.suning.framework.sedis.ShardedJedisAction;
import com.suning.framework.sedis.impl.ShardedJedisClientImpl;
import redis.clients.jedis.ShardedJedis;

public class RedisUtil {
    protected static ShardedJedisClientImpl shardedJedisClient;

    static {
        shardedJedisClient=new ShardedJedisClientImpl("redis_ucl.cnf");
    }

    public static String set(final String key,final String value){
        return shardedJedisClient.execute(new ShardedJedisAction<String>(){
            public String doAction(ShardedJedis shardedJedis){
                return shardedJedis.set(key,value);
            }
        });
    }
}
