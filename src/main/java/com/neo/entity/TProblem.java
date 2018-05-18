package com.neo.entity;

import java.io.Serializable;

public class TProblem implements Serializable {

	private static final long serialVersionUID = -3016754657239529273L;
	private String id;
	private String title;
	private String content;
	private String createTime;
	private String updateTime;
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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TProblem [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", status=" + status + "]";
	}
	
}