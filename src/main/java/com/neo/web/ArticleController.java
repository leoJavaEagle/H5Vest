package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@ResponseBody
	public BaseDataResp getArticles() {
		BaseDataResp resp = new BaseDataResp();
		List<TArticle> list=articleMapper.getAll();
		if(null == list){
			resp.setCode("000001");
			resp.setMessage("获取失败");
			return resp;
		}else{
			resp.setCode("000000");
			resp.setMessage("获取成功");
			resp.setData(list);
		}
		return resp;
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
//    	System.out.println(ta.getTitle());
    	if(null == ta){
			resp.setCode("000001");
			resp.setMessage("获取失败");
			return resp;
		}else{
			resp.setCode("000000");
			resp.setMessage("获取成功");
			resp.setData(ta);
		}
		return resp;
	}
	
	 @RequestMapping("/getArticleEdit")
	    public String getArticleEdit(){
			
			return "article/article_edit";
		}
	
    
    /**
	 * 插入一条资讯
	 * @param ta
	 */
	@ResponseBody
    @RequestMapping("/addArticle")
    public BaseDataResp save(TArticle ta) {
    	BaseDataResp resp = new BaseDataResp();
    	Integer s = articleMapper.insert(ta);
    	if(s==null){
    		resp.setCode("000001");
			resp.setMessage("添加失败");
			return resp;
    	}else{
			resp.setCode("000000");
			resp.setMessage("添加成功");
		}
    	return resp;
    }
    
    /**
	 * 更新全部资讯
	 * @param ta
	 */
	@ResponseBody
    @RequestMapping(value="/updateArticle")
    public BaseDataResp update(TArticle ta) {
//		System.out.println(ta.getStatus());
    	BaseDataResp resp = new BaseDataResp();
    	Integer s = articleMapper.update(ta);
//    	System.out.println(s);
    	if(s==0){
    		resp.setCode("000001");
			resp.setMessage("更新失败");
			return resp;
    	}else{
			resp.setCode("000000");
			resp.setMessage("更新成功");
		}
    	return resp;
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
    @ResponseBody
    @RequestMapping(value="/deleteArticle")
    public BaseDataResp delete(@RequestParam String id) {
    	BaseDataResp resp = new BaseDataResp();
    	Integer s = articleMapper.delete(id);
    	System.out.println(s);
    	if(s==null){
    		resp.setCode("000001");
			resp.setMessage("删除失败");
			return resp;
    	}else{
			resp.setCode("000000");
			resp.setMessage("删除成功");
		}
    	return resp;
    	
    }
    
    
}