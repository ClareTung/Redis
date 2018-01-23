package cn.iponkan.test;

import redis.clients.jedis.Jedis;

public class TestPing {
	public static void main(String[] args) {
		//连接 Redis 服务
		Jedis jedis = new Jedis("192.168.237.131",6379);
		//查看服务是否运行，打出PONG表示OK
		System.out.println(jedis.ping());
	}
}
