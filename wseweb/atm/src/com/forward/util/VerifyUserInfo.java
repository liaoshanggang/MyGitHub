package com.forward.util;

import com.forward.exception.CardInfoException;

public class VerifyUserInfo {

	public void verifyCardData(String cardNo) throws CardInfoException {
		if (cardNo.length() != 19) {
			throw new CardInfoException("账号位数不正确！");
		}
		/*if (!cardNo.matches("[0-9]+")){
			throw new CardInfoException("账号应该为纯数字！");
		}*/
		//...
	}
	
	public void verifyAccData(String acc) throws CardInfoException {
		if (acc.length() != 18) {
			throw new CardInfoException("账号位数不正确！");
		}
		if (!acc.matches("[0-9]+")){
			throw new CardInfoException("账号位数应该为纯数字！");
		}
		//...
	}

	public void verifyPwdData(int pwd) throws CardInfoException {
		if (String.valueOf(pwd).length() != 6) {
			throw new CardInfoException("密码位数不正确！");
		}
		//...
	}

	public void verifyBanData(double ban) throws CardInfoException {
		if (ban % 100 != 0) {
			throw new CardInfoException("请存整数！");
		}
		//...
	}

	public void verifyTypeData(String type) throws CardInfoException {
	}
}
