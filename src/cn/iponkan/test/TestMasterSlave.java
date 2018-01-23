package cn.iponkan.test;

import redis.clients.jedis.Jedis;

public class TestMasterSlave {
	public static void main(String[] args) throws InterruptedException {
		Jedis jedis_M = new Jedis("192.168.237.131",6381);
	    Jedis jedis_S = new Jedis("192.168.237.131",6379);
	     
	    jedis_S.slaveof("192.168.237.131",6381);
	     
	    jedis_M.set("k6","v6");
	    Thread.sleep(500);
	    System.out.println(jedis_S.get("k6"));
	}
}
