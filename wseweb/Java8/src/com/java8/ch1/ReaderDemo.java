package com.java8.ch1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReaderDemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src\\com\\java8\\ch1\\ReaderDemo.java"));
			String result = null;
			if((result=br.readLine())!=null){
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
