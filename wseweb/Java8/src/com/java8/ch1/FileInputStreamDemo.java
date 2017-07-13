package com.java8.ch1;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src\\com\\java8\\ch1\\FileInputStreamDemo.java");
			//缓冲区
			byte[] bbuf = new byte[1024];
			//保存实际读取的字节数
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf))>0) {
				for (int i = 0; i < bbuf.length; i++) {
					System.out.println("bbuf"+bbuf[i]);
				}
				System.out.println("hasRead"+hasRead+"bytes");
				System.out.println(new String(bbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
	}
}
