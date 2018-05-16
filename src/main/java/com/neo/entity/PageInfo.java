package com.neo.entity;

import java.io.Serializable;

public class PageInfo implements Serializable {

	private static final long serialVersionUID = -2077260360092938132L;

	/**
	 * 当前页
	 */
	private Integer page = 1;
	
	/**
	 * 总记录数
	 */
	private Integer countPage;
	
	/**
	 * 每页显示记录数
	 */
	private Integer showAmount;
	
	/**
	 * 起始下标
	 */
	private Integer startIndex;
	
	/**
	 * 总页数
	 */
	private Integer pageCount;

	public PageInfo() {
		super();
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCountPage() {
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getShowAmount() {
		return showAmount;
	}

	public void setShowAmount(Integer showAmount) {
		this.showAmount = showAmount;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getPageCount() {
		pageCount = countPage / showAmount;
		if(countPage % showAmount != 0) { // 余数不为0，页面加1
			pageCount ++;
		}
		return pageCount; // 返回总页数
	}
	
}
