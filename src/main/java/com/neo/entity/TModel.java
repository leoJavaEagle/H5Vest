package com.neo.entity;

import java.io.Serializable;

public class TModel implements Serializable
{
	private static final long serialVersionUID = -3670620687383035929L;

	/**
     * 主键id
     */
    private String id;
    
    /**
     * 手机系统来源
     */
    private String source;
    
    /**
     * 渠道商标识码
     */
    private String marketCode;
    
    /**
     * 渠道码
     */
    private String marketName;
    
    /**
     * 首页
     */
    private String index;
    
    /**
     * 资讯
     */
    private String article;
    
    /**
     * 计算器
     */
    private String counter;
    
    /**
     * 我的
     */
    private String mine;
    
    /**
     * 审核开始时间
     */
    private String startTime;
    
    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
     * 审核结束时间 
     */
    private String endTime;
    
    /**
     * 状态：0 审核中  1 审核结束
     */
    private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String getMine() {
		return mine;
	}

	public void setMine(String mine) {
		this.mine = mine;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
    
}
