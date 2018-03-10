package com.lanqiao.di.printer;

public class Paper {
	// 每页的行数
	private int lines;
	// 每行的字符数
	private int chars;
	// 打印到纸上的内容
	private String content;

	public Paper(int lines, int chars) {
		super();
		this.lines = lines;
		this.chars = chars;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getChars() {
		return chars;
	}

	public void setChars(int chars) {
		this.chars = chars;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
