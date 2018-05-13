package com.redis.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisTest {

	@Test
	public void Test() {
		Set<HostAndPort> ClusterNodes = new HashSet<HostAndPort>();
		// 1.随便选择集群中的一个节点
		ClusterNodes.add(new HostAndPort("192.168.137.141", 7001));
		JedisCluster jCluster = new JedisCluster(ClusterNodes);

		// 2.读取 key--value
//		String name = "";
//		name = jCluster.get("name");
//		System.out.println(name);

		// 3.设置 key--value
//		jCluster.set("time", "2017年10月24日13:20:47");
//		System.out.println(jCluster.get("time"));
		jCluster.set("number-2", "1004");
		System.out.println(jCluster.incr("number-2"));
	}

}
