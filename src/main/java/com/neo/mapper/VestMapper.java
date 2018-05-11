package com.neo.mapper;

import com.neo.entity.TModel;

public interface VestMapper {
	
	String findAuditingStatus(String source, String marketCode);
	
	TModel showModel(String source, String marketCode);

}
