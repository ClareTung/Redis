package cn.iponkan.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class TestWatch {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.237.131",6381);
		 //���key������ö�������ͱ�����
	     
	     jedis.watch("serialNum");
	     jedis.set("serialNum","s#####################");
	     jedis.unwatch();
	     
	     Transaction transaction = jedis.multi();//������һ���������ִ��
	     Response<String> response = transaction.get("serialNum");
	     transaction.set("serialNum","s002");
	     response = transaction.get("serialNum");
	     transaction.lpush("list3","a");
	     transaction.lpush("list3","b");
	     transaction.lpush("list3","c");
	     
	     transaction.exec();
	     //2 transaction.discard();
	     System.out.println("serialNum***********"+response.get());
	         
		
	}

}
