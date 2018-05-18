package com.neo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.TArticle;


public interface ArticleMapper {
	
	/**
	 * 获取所有资讯文章
	 * @return
	 */
	List<TArticle> getAll();
	
	/**
	 * 获取所有状态为显示的资讯文章
	 * @return
	 */
	List<TArticle> getAllByStatus();
	
	/**
	 * 根据id获取一条资讯
	 * @param id
	 * @return
	 */
	TArticle getOne(String id);
	
	/**
	 * 插入一条资讯
	 * @param ta
	 */
	Integer insert(TArticle ta);
	
	/**
	 * 更新全部资讯
	 * @param ta
	 */
	Integer update(TArticle ta);
	
	/**
	 * 更新资讯状态
	 * @param ta
	 */
	Integer updateStatus(TArticle ta);
	
	/**
	 * 删除一条资讯
	 * @param id
	 */
	Integer delete(@Param(value = "id") String id);

}