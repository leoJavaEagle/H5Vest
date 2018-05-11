package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.entity.TArticle;
import com.neo.mapper.ArticleMapper;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	/**
	 * 获取所有资讯文章
	 * @return
	 */
	@RequestMapping("/getArticles")
	public List<TArticle> getArticles() {
		List<TArticle> ta=articleMapper.getAll();
		return ta;
	}
	
	/**
	 * 获取所有状态为显示的资讯文章
	 * @return
	 */
	@RequestMapping("/getArticlesByStatus")
	public List<TArticle> getArticlesByStatus() {
		List<TArticle> ta=articleMapper.getAllByStatus();
		return ta;
	}
	
	/**
	 * 根据id获取一条资讯
	 * @param id
	 * @return
	 */
    @RequestMapping("/getArticle")
    public TArticle getArticle(String id) {
    	TArticle ta=articleMapper.getOne(id);
        return ta;
    }
    
    /**
	 * 插入一条资讯
	 * @param ta
	 */
    @RequestMapping("/addArticle")
    public void save(TArticle ta) {
    	articleMapper.insert(ta);
    }
    
    /**
	 * 更新全部资讯
	 * @param ta
	 */
    @RequestMapping(value="/updateArticle")
    public void update(TArticle ta) {
    	articleMapper.update(ta);
    }
    
    /**
	 * 更新资讯状态
	 * @param ta
	 */
    @RequestMapping(value="/updateStatus")
    public void updateStatus(TArticle ta) {
    	articleMapper.updateStatus(ta);
    }
    
    /**
	 * 删除一条资讯
	 * @param id
	 */
    @RequestMapping(value="/deleteArticle/{id}")
    public void delete(@PathVariable("id") String id) {
    	articleMapper.delete(id);
    }
    
}