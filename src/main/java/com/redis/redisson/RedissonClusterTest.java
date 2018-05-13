package com.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * http://aperise.iteye.com/blog/2396196
 * 
 * @author cheng
 *
 */
public class RedissonClusterTest {

	public static void main(String[] args) {
		// 创建配置
		Config config = new Config();
		// 指定使用集群部署方式
		config.useClusterServers()
				// 集群状态扫描间隔时间，单位是毫秒
				.setScanInterval(2000)
				// cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
				.addNodeAddress("redis://192.168.137.141:7001").addNodeAddress("redis://192.168.137.141:7002")
				.addNodeAddress("redis://192.168.137.141:7003").addNodeAddress("redis://192.168.137.141:7004")
				.addNodeAddress("redis://192.168.137.141:7005").addNodeAddress("redis://192.168.137.141:7006");
		// 创建客户端(发现这一非常耗时，基本在2秒-4秒左右)
		RedissonClient redisson = Redisson.create(config);

		// 首先获取redis中的key-value对象，key不存在没关系
		RBucket<String> keyObject = redisson.getBucket("key");
		// 如果key存在，就设置key的值为新值value
		// 如果key不存在，就设置key的值为value
		keyObject.set("value");
		System.out.println(keyObject.get());
		// 最后关闭RedissonClient
		redisson.shutdown();

	}

}
