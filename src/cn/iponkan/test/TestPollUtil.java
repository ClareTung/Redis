package cn.iponkan.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPollUtil {
	public static void main(String[] args) {
		 JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
	     Jedis jedis = null;
	     
	     try 
	     {
	       jedis = jedisPool.getResource();
	       jedis.set("k8","v8");
	       
	     } catch (Exception e) {
	       e.printStackTrace();
	     }finally{
	       JedisPoolUtil.release(jedisPool, jedis);
	     }

	}

}
