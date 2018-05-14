package com.neo.entity;

import java.io.Serializable;
import java.util.Date;

public class TProduct implements Serializable
{

	private static final long serialVersionUID = 7497623608779895909L;

	/**
     * 产品主键ID
     */
    private String id;
    
	/**
     * 0：现金贷、1：消费贷、2：抵押贷、3：租房分期、4：学生贷、5：业主贷
     */
    private String productType;
    
    /**
     * 借款产品名称
     */
    private String productName;
    
    /**
     * 产品图标URL
     */
    private String productPictureUrl;
    
    /**
     * 日利率
     */
    private String dayRate;
    
    /**
     * 月利率
     */
    private String monthRate;
    
    /**
     * 年利率
     */
    private String yearRate;
    
    /**
     * 借款期限（1-30天；6个月；12个月；18个月）
     */
    private String borrowPeriods;
    
    /**
     * 0：启用、1：停用、2：待提交
     */
    private String status;
    
    /**
     * 创建时间
     */
    private String createTime;
    
    /**
     * 最后修改时间
     */
    private Date updateTime;
    
    /**
     * 第三方产品的URL
     */
    private String outUrl;
    
    /**
     * 额度范围
     */
    private String amountLimit;
    
    /**
     * 多长时间下款
     */
    private String  bizTime;
    
    /**
     * 是否默认产品
     */
    private String isDefault;
    
    /**
     * 小logo图片
     */
    private String logoTip;
    
    /**
     * 小logo右边的产品提示
     */
    private String productTip;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPictureUrl() {
		return productPictureUrl;
	}

	public void setProductPictureUrl(String productPictureUrl) {
		this.productPictureUrl = productPictureUrl;
	}

	public String getDayRate() {
		return dayRate;
	}

	public void setDayRate(String dayRate) {
		this.dayRate = dayRate;
	}

	public String getMonthRate() {
		return monthRate;
	}

	public void setMonthRate(String monthRate) {
		this.monthRate = monthRate;
	}

	public String getYearRate() {
		return yearRate;
	}

	public void setYearRate(String yearRate) {
		this.yearRate = yearRate;
	}

	public String getBorrowPeriods() {
		return borrowPeriods;
	}

	public void setBorrowPeriods(String borrowPeriods) {
		this.borrowPeriods = borrowPeriods;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOutUrl() {
		return outUrl;
	}

	public void setOutUrl(String outUrl) {
		this.outUrl = outUrl;
	}

	public String getAmountLimit() {
		return amountLimit;
	}

	public void setAmountLimit(String amountLimit) {
		this.amountLimit = amountLimit;
	}

	public String getBizTime() {
		return bizTime;
	}

	public void setBizTime(String bizTime) {
		this.bizTime = bizTime;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getLogoTip() {
		return logoTip;
	}

	public void setLogoTip(String logoTip) {
		this.logoTip = logoTip;
	}

	public String getProductTip() {
		return productTip;
	}

	public void setProductTip(String productTip) {
		this.productTip = productTip;
	}

	@Override
	public String toString() {
		return "TProduct [id=" + id + ", productType=" + productType + ", productName=" + productName
				+ ", productPictureUrl=" + productPictureUrl + ", dayRate=" + dayRate + ", monthRate=" + monthRate
				+ ", yearRate=" + yearRate + ", borrowPeriods=" + borrowPeriods + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", outUrl=" + outUrl + ", amountLimit=" + amountLimit
				+ ", bizTime=" + bizTime + ", isDefault=" + isDefault + ", logoTip=" + logoTip + ", productTip="
				+ productTip + "]";
	}
    
	
}