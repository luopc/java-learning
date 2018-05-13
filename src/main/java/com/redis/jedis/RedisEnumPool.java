package com.redis.jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public enum RedisEnumPool {
	
	INSTANCE;
	
	private JedisPool pool;
	
	RedisEnumPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxWaitMillis(1000);
		config.setMaxIdle(10);
		pool = new JedisPool(config, "192.168.137.141", 7001);
	}
	
	public JedisPool getInstance() {
		System.out.println("Enum single~");
		return pool;
	}
}
