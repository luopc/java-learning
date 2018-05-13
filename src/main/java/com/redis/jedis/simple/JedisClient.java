package com.redis.jedis.simple;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis客户端
 * 
 * @author yangfenge 2016年6月2日
 */
public class JedisClient {
	private static JedisPool pool;

	/**
	 * 获取redis客户端jedis
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static Jedis GetIntance(String host, int port) {
		pool = RedisPool.GetIntance(host, port);
		return pool.getResource();
	}

	/**
	 * 释放redis客户端jedis
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static void ReturnJedisToPool(Jedis jedis) {
		pool.returnResourceObject(jedis);
	}
}
