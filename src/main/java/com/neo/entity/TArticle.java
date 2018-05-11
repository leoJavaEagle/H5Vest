package com.neo.entity;

import java.io.Serializable;

public class TArticle implements Serializable
{
	private static final long serialVersionUID = 6200652150476499801L;

	/**
     * 主键id
     */
    private String id;
    
    /**
     * 文章标题
     */
    private String title;
    
    /**
     * 文章内容
     */
    private String content;
    
    /**
     * 文章阅读量
     */
    private String readCount;
    
    /**
     * 文章图片路径 
     */
    private String image;
    
    /**
     * 签订时间
     */
    private String createTime;
    
    /**
     * 状态：0 显示  1 不显示
     */
    private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTittle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}