package com.javaex.vo;

public class BlogVo {
	//필드
	private String id;			//회원식별(아이디)
	private String blogTitle;	//블로그제목
	private String logoFile;	//블로그 이미지 경로
	private String userName;	//회원이름
	
	//생성자
	public BlogVo() {}

	
	public BlogVo(String id, String blogTitle, String logoFile) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}

	public BlogVo(String id, String blogTitle, String logoFile, String userName) {
		this.id = id;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.userName = userName;
	}

	//메소드-g/s
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	//일반메소드
	
	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + ", userName=" + userName
				+ "]";
	}

	
}
