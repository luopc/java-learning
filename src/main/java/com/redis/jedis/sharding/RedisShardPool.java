package com.redis.jedis.sharding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

public class RedisShardPool  {
	
	private static ShardedJedisPool pool;

	/**
	 * 创建分片连接池
	 * 
	 * @param confs
	 *            分片的各个机器配置
	 */
	private static void createJedisPool(List<Map<String, Integer>> confs) {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 设置最大连接数
		jedisPoolConfig.setMaxTotal(100);
		// 设置最大阻塞时间，记住是毫秒数milliseconds
		jedisPoolConfig.setMaxWaitMillis(1000);
		// 设置空间连接
		jedisPoolConfig.setMaxIdle(10);
		List<JedisShardInfo> jedisShardInfos = new ArrayList<JedisShardInfo>();
		for (Map<String, Integer> item : confs) {
			Set<Entry<String, Integer>> conf = item.entrySet();
			for (Entry<String, Integer> entry : conf) {
				JedisShardInfo jedisShardInfo = new JedisShardInfo(entry.getKey(), entry.getKey());
				jedisShardInfos.add(jedisShardInfo);
				break;
			}
		}
		// 创建连接池
		pool = new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
	}

	/**
	 * 同步初始化连接池，防止多线程调用重复创建
	 * 
	 * @param confs
	 *            分片的各个机器配置
	 */
	public static synchronized ShardedJedisPool GetIntance(List<Map<String, Integer>> confs) {
		if (pool == null) {
			createJedisPool(confs);
		}
		return pool;
	}
}
