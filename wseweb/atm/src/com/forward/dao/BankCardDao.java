package com.forward.dao;

import java.util.List;

import com.forward.po.trade.BankCard;

public interface BankCardDao {
	/**
	 * @Description:添加卡号信息
	 * @param tags
	 * @return return_type
	 */
	public int addCardInfo(BankCard bankCard);
	
	/**
	 * @Description: 根据账户查询卡信息
	 * @param tags
	 * @return return_type
	 */
	public boolean queryCardInfoByAcc(String acc_id);
	
	/**
	 * @Description:根据卡号和密码查询卡信息
	 * @param cardNO,password
	 * @return 返回卡信息
	 */
	public BankCard getCardInfo(String cardNo,int password);
	
	/**
	 * @Description: 更新卡号余额
	 * @param cardNO
	 * @return return_type
	 */
	public int withDrawMoney(String cardNo,double balance);
	
	public List<BankCard> queryALlCardInfo();

	public int depositMoney(String cardNo, double money);
	
	public int tranfer(String from, String to, double money);
}
