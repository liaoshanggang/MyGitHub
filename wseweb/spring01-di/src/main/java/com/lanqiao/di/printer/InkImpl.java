package com.lanqiao.di.printer;

import java.awt.Color;

public class InkImpl implements Ink{
	private int red; // 0~256
	private int green;
	private int blue;
	
	public InkImpl() {
		super();
	}

	public InkImpl(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}


	public String getColor() {
		Color color = new Color(red, green, blue);
		int rgb = color.getRGB();
		return "#"+Integer.toHexString(rgb).substring(2);
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}
	public static void main(String[] args) {
		String s = new InkImpl(100,10,200).getColor();
		System.out.println(s);
	}
	
}
