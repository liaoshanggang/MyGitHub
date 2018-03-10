package com.java8.ch1;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterDemo {
	public static void main(String[] args) {
		//根据已经存在的路径创建File对象
		File file = new File("C://");
		if (file.exists() && file.isDirectory()) {
			String[] allFileNames = file.list();
			for (String name : allFileNames) {
				System.out.println(name);
			}
			System.out.println("----------------------");
			String[] fileFileNames = file.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".zip") || name.endsWith(".txt");
				}
			});
			System.out.println("过滤后的文件列表：");
			for (String name : fileFileNames) {
				System.out.println(name);
			}
		}
		System.out.println("hello");
	}
}
