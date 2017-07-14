package com.forward.po.trade;

//交易流水信息：交易类型，交易代码，账号，交易时间
public class TradeInfo {
	String tradeType;// 交易类型
	String tradeCode;// 交易代码
	String accountNo;// 账号
	String tradeTime;// 交易时间

	public TradeInfo() {
		super();
	}

	public TradeInfo(String tradeType, String tradeCode, String accountNo,
			String tradeTime) {
		super();
		this.tradeType = tradeType;
		this.tradeCode = tradeCode;
		this.accountNo = accountNo;
		this.tradeTime = tradeTime;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public String toString() {
		return "TradeInfo [tradeType=" + tradeType + ", tradeCode=" + tradeCode
				+ ", accountNo=" + accountNo + ", tradeTime=" + tradeTime + "]";
	}

}
