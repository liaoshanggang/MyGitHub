package com.oracle.util;

import com.oracle.exception.EmpInfoException;

public class VerifyEmpInfo {

	public void verifyCardData(String cardNo) throws EmpInfoException {
		if (cardNo.length() != 19) {
			throw new EmpInfoException("账号位数不正确！");
		}
		/*
		 * if (!cardNo.matches("[0-9]+")){ throw new
		 * CardInfoException("账号应该为纯数字！"); }
		 */
		// ...
	}

	public void verifyAccData(String acc) throws EmpInfoException {
		if (acc.length() != 18) {
			throw new EmpInfoException("账号位数不正确！");
		}
		if (!acc.matches("[0-9]+")) {
			throw new EmpInfoException("账号位数应该为纯数字！");
		}
		// ...
	}

	public void verifyPwdData(int pwd) throws EmpInfoException {
		if (String.valueOf(pwd).length() != 6) {
			throw new EmpInfoException("密码位数不正确！");
		}
		// ...
	}

	public void verifyBanData(double ban) throws EmpInfoException {
		if (ban % 100 != 0) {
			throw new EmpInfoException("请存整数！");
		}
		// ...
	}

	public void verifyTypeData(String type) throws EmpInfoException {
	}
}
