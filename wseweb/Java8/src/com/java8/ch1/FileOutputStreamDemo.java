package com.java8.ch1;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("src\\com\\java8\\ch1\\FileOutputStreamDemo.txt",true);
			fos.write("hello".getBytes());
			System.out.println("已保存！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
