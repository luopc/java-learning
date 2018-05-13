package com.redis.jedis.sharding;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/** 
 * redis分片客户端 
 *  
 * @author yangfenge 2016年6月2日 
 */  
public class JedisShardClient {  
    private static ShardedJedisPool pool;  
  
    /** 
     * 获取redis分片客户端jedis 
     *  
     * @param host 
     * @param port 
     * @return 
     */  
    public static ShardedJedis GetIntance(List<Map<String, Integer>> confs) {  
        pool = RedisShardPool.GetIntance(confs);  
        return pool.getResource();  
    }  
  
    /** 
     * 释放redis客户端分片jedis 
     *  
     * @param host 
     * @param port 
     * @return 
     */  
    public static void ReturnJedisToPool(ShardedJedis jedis) {  
        pool.returnResourceObject(jedis);  
    }  
}  
