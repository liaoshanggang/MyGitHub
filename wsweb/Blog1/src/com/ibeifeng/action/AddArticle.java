package com.ibeifeng.action;

import java.util.Date;
import java.util.Map;

import com.ibeifeng.po.Article;
import com.ibeifeng.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddArticle extends ActionSupport {
	private String title;
	private String content;
	private ArticleService articleService;
	
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		//封装一个PO类的对象
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setUsername(username);
		article.setDate(new Date());
		article.setHasread(0);
		
		/*System.out.println(title);
		System.out.println(content);
		System.out.println(username);
		System.out.println(new Date());*/
		
		articleService.addArticle(article);
		return this.SUCCESS;
	}
}
