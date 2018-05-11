package com.neo.entity;

import java.io.Serializable;

public class TAuditing implements Serializable
{
	private static final long serialVersionUID = -746296776426142698L;

	/**
     * 主键id
     */
    private String id;
    
    /**
     * 手机系统来源
     */
    private String source;
    
    /**
     * 渠道码
     */
    private String marketCode;
    
    /**
     * 审核开始时间
     */
    private String startTime;
    
    /**
     * 审核结束时间 
     */
    private String endTime;
    
    /**
     * 状态：0 审核  1 非审核
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

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}