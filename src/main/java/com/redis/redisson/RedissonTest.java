package com.redis.redisson;

import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonTest {

	public static void main(String[] args) {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://192.168.137.141:7001");
		RedissonClient redisson = Redisson.create(config);
		try {
			redisson.getConfig().toJSON().toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
