package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neo.entity.BaseDataResp;
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
	public Object getArticles() {
		ModelAndView mv = new ModelAndView();
		List<TArticle> taList=articleMapper.getAll();
		mv.addObject("list", taList);
		return mv;
	}
	
	/**
	 * 获取所有状态为显示的资讯文章--前台显示接口
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArticlesByStatus")
	public BaseDataResp getArticlesByStatus() {
		BaseDataResp resp = new BaseDataResp();
		List<TArticle> taList=articleMapper.getAllByStatus();
		if(null == taList){
			resp.setCode("000001");
			resp.setMessage("获取失败");
			return resp;
		}else{
			resp.setCode("000000");
			resp.setMessage("获取成功");
			resp.setData(taList);
		}
		return resp;
	}
	
	/**
	 * 根据id获取一条资讯
	 * @param id
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getArticle")
    public BaseDataResp getArticle(@RequestParam String id) {
    	BaseDataResp resp = new BaseDataResp();
    	TArticle ta=articleMapper.getOne(id);
    	resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(ta);
        return resp;
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