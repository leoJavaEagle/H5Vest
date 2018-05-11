package com.neo.req;

import java.io.Serializable;

public class Source implements Serializable {

	private static final long serialVersionUID = -8032914395452150160L;
	private String source;
	private String marketCode;
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
	
	
}
