package com.neo.mapper;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.TModel;

public interface VestMapper {
	
	String findAuditingStatus(@Param("source")String source, @Param("marketCode")String marketCode);
	
	TModel showModel(@Param("source")String source, @Param("marketCode")String marketCode);
	
	TModel showModelAndStatus(@Param("source")String source, @Param("marketCode")String marketCode);

}
