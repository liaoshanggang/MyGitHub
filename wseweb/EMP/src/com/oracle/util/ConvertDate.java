package com.oracle.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConvertDate {

	public Date setTime() {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStringToParse = "2017-8-8";
		java.sql.Date sqlDate = null;
		java.util.Date date = null;
		try {
			date = bartDateFormat.parse(dateStringToParse);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(sqlDate);
		return sqlDate;
	}

	public static void main(String[] args) {
		new ConvertDate().setTime();
	}
}
