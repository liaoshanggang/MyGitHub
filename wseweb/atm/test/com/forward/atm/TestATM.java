package com.forward.atm;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.forward.po.trade.BankCard;
import com.forward.service.ATMServer;

public class TestATM {
	static ATMServer atmServer;

	@BeforeClass
	public static void initClass() {
		atmServer = new ATMServer();
	}

	@Ignore
	@Test 
	public void tranfer(){
		String from = "6228210000000000000";
		String to = "6228210000000000001";
		double money = 2000.0;
		
		int index = atmServer.tranfer(from,to, money);

		assertEquals(1,index);
	}
	
	@Test
	public void testQueryALlCardInfo(){
		java.util.List<BankCard> BanCard = atmServer.queryALlCardInfo();
		for (BankCard bankCard : BanCard) {
			System.out.println(bankCard);
		}
	}
	
	@Test
	public void testDepositMoney(){
		String cardNo = "6228210000000000000";
		double money = 0;
		
		int index = atmServer.depositMoney(cardNo, money);

		assertEquals(1,index);
	}
	
	@Test
	public void testWithDraw() {
		String cardNo = "6228210000000000000";
		double money = 0;
		
		int index = atmServer.withDrawMoney(cardNo, money);

		assertEquals(1,index);
	}
	
	@Test
	public void testLogin() {

		String cardNo = "6228210000000000000";
		String acc = "451111222233334444";
		int pwd = 123456;
		String type = "Agricultural Bank of China";
		double ban = 100000.0;

		BankCard actCardInfo = atmServer.login(cardNo, pwd);

		BankCard excCardInfo = new BankCard(cardNo, acc, pwd, type, ban);

		assertEquals(excCardInfo.toString(), actCardInfo.toString());
		// System.out.println("登录成功！");
	}

	@Test
	public void testRegister() {
		// String cardNo = "6228210987654321999";//自动生成
		String acc = "451111222233339914";// 自动生成，为了显示注册功能，此处可设置身份证
		int pwd = 123456;
		String type = "Agricultural Bank of China";
		double ban = 100000.0;

		BankCard actCardInfo = atmServer.register(acc, pwd, type, ban);
		BankCard excCardInfo = new BankCard(acc, pwd, type, ban);
		
		assertEquals(excCardInfo.toString(), actCardInfo.toString());
		// System.out.println("注册成功！");
	}
}
