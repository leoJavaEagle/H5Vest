package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TArticle;
import com.neo.entity.TProduct;
import com.neo.mapper.ArticleMapper;
import com.neo.mapper.IndexMapper;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private IndexMapper indexMapper;
	@Autowired
	private ArticleMapper articleMapper;

	@RequestMapping("/index")
	@ResponseBody
	public BaseDataResp showIndex() {
		BaseDataResp resp = new BaseDataResp();
		List<TProduct> list = indexMapper.showIndex();
		if(list == null) {
			resp.setCode("000001");
			resp.setMessage("查询失败");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(list);
		return resp;
	}
	
	@RequestMapping("/showIndexPage")
	public String showIndexPage() {
		return "index";
	}
	
	@RequestMapping("/showProduct")
	public String showProduct() {
		return "product/project_list";
	}
	
	/**
	 * 获取所有资讯文章
	 * @return
	 */
	@RequestMapping("/showArticle")
	public ModelAndView getArticles() {
		ModelAndView mv = new ModelAndView("article/article_list");
		return mv;
	}
	
	/**
	 * 获取
	 * @return
	 */
	@RequestMapping("/showModel")
	public ModelAndView getModel() {
		ModelAndView mv = new ModelAndView("model/model_list");
		return mv;
	}
	
}
