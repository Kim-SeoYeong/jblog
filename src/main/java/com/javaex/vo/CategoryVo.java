package com.javaex.vo;

public class CategoryVo {
	//필드
	private int cateNo;			//카테고리식별번호
	private String id;			//회원아이디
	private String cateName;	//카테고리명
	private String description;	//카테고리설명
	private String regDate;		//등록일
	private int postCnt;		//포스트갯수
	
	//생성자
	public CategoryVo() {}

	public CategoryVo(String id, String cateName, String description) {
		super();
		this.id = id;
		this.cateName = cateName;
		this.description = description;
	}

	public CategoryVo(int cateNo, String id, String cateName, String description, String regDate, int postCnt) {
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
		this.postCnt = postCnt;
	}

	//메소드-g/s
	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public int getPostCnt() {
		return postCnt;
	}

	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}

	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + ", postCnt=" + postCnt + "]";
	}
	
	
	
}
