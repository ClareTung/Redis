package cn.iponkan.test;

import redis.clients.jedis.Jedis;

public class TestPing {
	public static void main(String[] args) {
		//���� Redis ����
		Jedis jedis = new Jedis("192.168.237.131",6379);
		//�鿴�����Ƿ����У����PONG��ʾOK
		System.out.println(jedis.ping());
	}
}
