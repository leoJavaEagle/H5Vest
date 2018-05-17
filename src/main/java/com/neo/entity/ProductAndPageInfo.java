package com.neo.entity;

import java.io.Serializable;

public class ProductAndPageInfo implements Serializable {

	private static final long serialVersionUID = -317452960575038674L;
	private Integer pageCurrent;
	private String productName;
	private String status;
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
