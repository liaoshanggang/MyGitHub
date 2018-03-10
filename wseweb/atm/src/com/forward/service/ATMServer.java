package com.forward.service;

import java.util.List;

import com.forward.dao.BankCardDao;
import com.forward.dao.impl.BankCardDaoImpl;
import com.forward.exception.CardInfoException;
import com.forward.po.trade.BankCard;
import com.forward.util.VerifyUserInfo;

public class ATMServer {
	BankCardDao bCardDao = new BankCardDaoImpl();
	VerifyUserInfo v = new VerifyUserInfo();

	// 注册
	public BankCard register(String acc, int pwd, String type, double ban) {
		System.out.println(acc+""+pwd+""+type+""+ban);
		// 验证输入的数据
		try {
			v.verifyAccData(acc);
			v.verifyPwdData(pwd);
			v.verifyBanData(ban);
		} catch (CardInfoException e) {
			System.out.println(e.getMessage());
		}

		// 从数据库验证数据
		BankCard cardInfo = new BankCard(acc, pwd, type, ban);
		BankCard outCardInfo = null;
		// 验证卡号是否已经存在
		try {
			if (bCardDao.queryCardInfoByAcc(acc)) {
				throw new CardInfoException("卡号已存在！请重新输入");
			} else {
				int flag = bCardDao.addCardInfo(cardInfo);
				if (flag == 1) {
					outCardInfo = new BankCard(acc, pwd, type, ban);
				}
			}
		} catch (CardInfoException e1) {
			System.out.println(e1.getMessage());
		}
		return outCardInfo;
	}

	// 登录
	public BankCard login(String cardNo, int pwd) {
		// 验证输入的数据
		try {
			v.verifyCardData(cardNo);
			v.verifyPwdData(pwd);
		} catch (CardInfoException e) {
			System.out.println(e.getMessage());
		}
		// 从数据库验证数据
		BankCard bCard = null;
		bCard = bCardDao.getCardInfo(cardNo, pwd);
		return bCard;
	}

	// 取款
	public int withDrawMoney(String cardNo, double money) {
		// 验证输入的数据
		try {
			v.verifyCardData(cardNo);
			v.verifyBanData(money);
		} catch (CardInfoException e) {
			System.out.println(e.getMessage());
		}
		return bCardDao.withDrawMoney(cardNo, money);
	}

	// 查询
	public List<BankCard> queryALlCardInfo() {
		return bCardDao.queryALlCardInfo();
	}

	// 存款
	public int depositMoney(String cardNo, double money) {
		// 验证输入的数据
		try {
			v.verifyCardData(cardNo);
			v.verifyBanData(money);
		} catch (CardInfoException e) {
			System.out.println(e.getMessage());
		}
		return bCardDao.depositMoney(cardNo, money);
	}
	
public int tranfer(String from, String to, double money) {
		
		return bCardDao.tranfer(from,to, money);
	}
}
