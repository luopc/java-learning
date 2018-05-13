package com.redis.jedis;

import com.redis.jedis.simple.JedisClient;

import redis.clients.jedis.Jedis;

public class JedisClientTest {

	public static void main(String[] args) {
		Jedis jedis = JedisClient.GetIntance("192.168.137.141", 7001);
		String value = jedis.get("time");
		System.out.println(value);
		
//		jedis.set("number-1", "1000");
		System.out.println(jedis.get("number-1"));
	}

}
