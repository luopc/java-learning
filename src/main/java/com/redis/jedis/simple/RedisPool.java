package com.redis.jedis.simple;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

	private static JedisPool pool;

	private static void createJedisPool(String host, int port) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxWaitMillis(1000);
		config.setMaxIdle(10);
		pool = new JedisPool(config, host, port);
	}

	/**
	 * 同步初始化连接池，防止多线程调用重复创建
	 * @param host redis机器地址
	 * @param port
	 *            redis机器端口
	 */
	public static synchronized JedisPool GetIntance(String host, int port) {
		if (pool == null) {
			createJedisPool(host, port);
		}
		return pool;
	}
}
