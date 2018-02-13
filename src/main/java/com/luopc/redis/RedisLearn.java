package com.luopc.redis;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisLearn {
	
	private Jedis jedis = new Jedis("192.168.137.130", 7200);
	
	@Before
	public void initJedis() {
		System.out.println("服务器正在运行: " + jedis.ping());
	}

	@Test
	public void testConnect() {
		// 连接本地的 Redis 服务
//		Jedis jedis = new Jedis("192.168.137.130", 7200);
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务器正在运行: " + jedis.ping());
	}
	
	@Test
	public void redisSetTest(){
		jedis.set("java-1", "redis-set01");
	}
	
	@Test
	public void plistTest() {
		jedis.lpush("java-list", "zhangsan");
		jedis.lpush("java-list", "lisi");
		jedis.lpush("java-list", "wangwu");
		jedis.lpush("java-list", "zhaoliu");
		
		List<String> rList = jedis.lrange("java-list", 0, 10);
		for (String str : rList) {
			System.out.println("数据项：" + str);
		}
	}
	
}
