package com.lanqiao.service;

public interface IBookService {
	/**
	 * 购买书籍
	 * @param bookName 书名
	 * @param username 购买人
	 * @param price 价格
	 */
	public void buy(String bookName, String username, double price);
	
	/**
	 * 发表书评
	 * @param username 评论人
	 * @param comment 评语
	 */
	public void comments(String username, String comment);
}
