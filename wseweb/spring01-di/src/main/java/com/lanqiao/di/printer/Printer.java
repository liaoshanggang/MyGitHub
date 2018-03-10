package com.lanqiao.di.printer;

public class Printer {
	private Ink ink = null;
	private Paper paper;
	
	public Ink getInk() {
		return ink;
	}
	public void setInk(Ink ink) {
		this.ink = ink;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public void print(String content) {
		this.paper.setContent(content);
		System.out.println("----------------------打印到纸上的内容------------------");
		System.out.println(this.paper.getContent());
		
		System.out.println("用 " + this.ink.getColor() + " 颜色打印！");
		System.out.println("每页打印" + this.paper.getLines() + "行！");
		System.out.println("每行打印" + this.paper.getChars() + "个字符！");
		
	}
}
