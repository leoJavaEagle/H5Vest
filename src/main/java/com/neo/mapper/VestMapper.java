package com.neo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.TArticle;
import com.neo.entity.TModel;

public interface VestMapper {
	
	String findAuditingStatus(@Param("source")String source, @Param("marketCode")String marketCode);
	
	TModel showModel(@Param("source")String source, @Param("marketCode")String marketCode);
	
	TModel showModelAndStatus(@Param("source")String source, @Param("marketCode")String marketCode);
	
	List<TModel> getAll();

	TModel getOne(String id);
	
	Integer insert(TModel model);

	Integer update(TModel model);

	Integer delete(@Param(value = "id") String id);

}
