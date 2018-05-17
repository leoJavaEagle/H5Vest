package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TProblem;
import com.neo.entity.TArticle;
import com.neo.entity.TProduct;
import com.neo.mapper.ArticleMapper;
import com.neo.mapper.IndexMapper;
import com.neo.mapper.ProblemMapper;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private IndexMapper indexMapper;
	
	@Autowired
	private ProblemMapper problemMapper;

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
		return "product/product_list";
	}
	
	@RequestMapping("/showProductInfo")
	@ResponseBody
	public BaseDataResp showProductInfo(@RequestBody TProduct product) {
		BaseDataResp resp = new BaseDataResp();
		if(product.getProductName() == null && product.getStatus() == null) {
			List<TProduct> list = indexMapper.showProduct();
			if(list.size() == 0) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
				return resp;
			}
			resp.setCode("000000");
			resp.setMessage("成功");
			resp.setData(list);
			return resp;
		}else {
			List<TProduct> productInfo = indexMapper.findProductByTitleOrStatus(product.getProductName(), product.getStatus());
			if(productInfo == null) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
				return resp;
			}
			resp.setCode("000000");
			resp.setMessage("成功");
			resp.setData(productInfo);
			return resp;
		}
	}
	
	@RequestMapping("showProductEdit")
	public String showProductEdit() {
		return "product/product_edit";
	}
	
	@RequestMapping("findProductById")
	@ResponseBody
	public BaseDataResp findproductById(@RequestParam("id") String productId) {
		BaseDataResp resp = new BaseDataResp();
		TProduct product = indexMapper.findProductById(productId);
		if(product == null) {
			resp.setCode("000001");
			resp.setMessage("没有数据");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(product);
		return resp;
	}
	
	@RequestMapping("updateProduct")
	@ResponseBody
	public BaseDataResp updateProduct(@RequestBody TProduct product) {
		BaseDataResp resp = new BaseDataResp();
		Integer check = indexMapper.updateProduct(product);
		if(check < 1) {
			resp.setCode("000001");
			resp.setMessage("没有数据");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(product);
		return resp;
	}
	
	@RequestMapping("insertProduct")
	@ResponseBody
	public BaseDataResp insertProduct(@RequestBody TProduct product) {
		String productId = (int)((Math.random()*9+1)*1000) + "" + (int)((Math.random()*9+1)*1000);
		product.setId(productId);
		BaseDataResp resp = new BaseDataResp();
		Integer check = indexMapper.insertProduct(product);
		if(check < 1) {
			resp.setCode("000001");
			resp.setMessage("没有数据");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(product);
		return resp;
	}
	
	@RequestMapping("showProblem")
	public String showProblem() {
		return "problem/problem_list";
	}
	
	@RequestMapping("showProblemInfo")
	@ResponseBody
	public BaseDataResp showProblemInfo(@RequestBody TProblem problem) {
		BaseDataResp resp = new BaseDataResp();
		if(problem.getTitle() == "" && problem.getStatus() == "") {
			List<TProblem> list = problemMapper.showAllProblem();
			if(list.size() < 1) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
				return resp;
			}
			resp.setCode("000000");
			resp.setMessage("成功");
			resp.setData(list);
			return resp;
		}else {
			List<TProblem> list = problemMapper.findProblemByTitleOrStatus(problem.getTitle(), problem.getStatus());
			if(list.size() < 1) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
				return resp;
			}
			resp.setCode("000000");
			resp.setMessage("成功");
			resp.setData(list);
			return resp;
		}
	}
	
	@RequestMapping("showProblemEdit")
	public String showProblemEdit() {
		return "problem/problem_edit";
	}
	
	@RequestMapping("findProblemById")
	@ResponseBody
	public BaseDataResp findProblemById(@RequestParam("id")String id) {
		BaseDataResp resp = new BaseDataResp();
		TProblem problem = problemMapper.showProblemDetails(id);
		if(problem == null) {
			resp.setCode("000001");
			resp.setMessage("没有数据");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(problem);
		return resp;
	}
	
	@RequestMapping("updateProblem")
	@ResponseBody
	public BaseDataResp updateProblem(@RequestBody TProblem problem) {
		BaseDataResp resp = new BaseDataResp();
		Integer check = problemMapper.updateProblem(problem);
		if(check < 1) {
			resp.setCode("000001");
			resp.setMessage("没有数据");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(problem);
		return resp;
	}
	
	@RequestMapping("insertProblem")
	@ResponseBody
	public BaseDataResp insertProblem(@RequestBody TProblem problem) {
		String prblemId = (int)((Math.random()*9+1)*1000) + "" + (int)((Math.random()*9+1)*1000);
		problem.setId(prblemId);
		BaseDataResp resp = new BaseDataResp();
		Integer check = problemMapper.insertProblem(problem);
		if(check < 1) {
			resp.setCode("000001");
			resp.setMessage("没有数据");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(problem);
		return resp;
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
