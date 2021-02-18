package com.javaex.vo;

public class BlogVo {
	//필드
	private String id;			//식별번호(아이디)
	private String blogTitle;	//블로그제목
	private String logoFile;	//블로그이미지경로
	
	public BlogVo(String id, String blogTitle, String logoFile) {
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}
	
	
}
