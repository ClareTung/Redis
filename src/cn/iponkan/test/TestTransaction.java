package cn.iponkan.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTransaction {
	  public boolean transMethod() {
		  Jedis jedis = new Jedis("192.168.237.131",6381);
		  int balance;// 可用余额
		  int debt;// 欠额
		  int amtToSubtract = 10;// 实刷额度


		  jedis.watch("balance");
		  //jedis.set("balance","5");
		  balance = Integer.parseInt(jedis.get("balance"));
		  if (balance < amtToSubtract) {
		    jedis.unwatch();
		    System.out.println("modify");
		    return false;
	     } else {
	       System.out.println("***********transaction");
	       Transaction transaction = jedis.multi();
	       transaction.decrBy("balance", amtToSubtract);
	       transaction.incrBy("debt", amtToSubtract);
	       transaction.exec();
	       balance = Integer.parseInt(jedis.get("balance"));
	       debt = Integer.parseInt(jedis.get("debt"));


	       System.out.println("*******" + balance);
	       System.out.println("*******" + debt);
	       return true;
	     }
	  }
	  
	  public static void main(String[] args) {
		  TestTransaction test = new TestTransaction();
	      boolean retValue = test.transMethod();
	      System.out.println("main retValue-------: " + retValue);
	  }

}
