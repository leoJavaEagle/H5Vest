package com.neo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neo.entity.BaseDataResp;
import com.neo.entity.PageInfo;
import com.neo.entity.ProductAndPageInfo;
import com.neo.entity.TProblem;
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
	
	public PageInfo setPageInfo(Integer pageCurrent) {
		
//		int pageCurrent = product.getPageCurrent();
//		int pageCurrents = Integer.parseInt(pageCurrent);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(pageCurrent); // 当前页
		pageInfo.setShowAmount(3); // 设置每页显示的记录数
		int startIndex = (pageCurrent - 1) * pageInfo.getShowAmount(); // 计算起始下标
		pageInfo.setStartIndex(startIndex);
		return pageInfo;
	}
	
	@RequestMapping(value="/showProductInfo", method=RequestMethod.POST)
	@ResponseBody
//	public BaseDataResp showProductInfo(@RequestBody TProduct product) {
//	public BaseDataResp showProductInfo(@RequestParam("pageCurrent") Integer pageCurrent, 
//			@RequestParam("productName") String productName, 
//			@RequestParam("status") String status) {
	public BaseDataResp showProductInfo(@RequestBody ProductAndPageInfo product) {
		BaseDataResp resp = new BaseDataResp();
		int pageCurrent = product.getPageCurrent();
		PageInfo pageInfo = setPageInfo(pageCurrent);
		List<TProduct> productAll = indexMapper.showProductAll();
		if(productAll.size() > 0) {
			pageInfo.setCountPage(productAll.size()); // 总行数
		}else {
			pageInfo.setCountPage(1);
		}
		if(product.getProductName() == "" && product.getStatus() == "") {
			List<TProduct> list = indexMapper.showProduct(pageInfo.getStartIndex(), pageInfo.getShowAmount());
			if(list.size() > 0) {
				resp.setCode("000000");
				resp.setMessage("成功");
			}else {
				resp.setCode("000001");
				resp.setMessage("没有数据");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productInfo", list);
			map.put("pageInfo", pageInfo);
			resp.setData(map);
			return resp;
		}else {
//			List<TProduct> productInfo = indexMapper.findProductByTitleOrStatus(product.getProductName(), product.getStatus());
			List<TProduct> productInfoAll = indexMapper.findProductByTitleOrStatusAll(product.getProductName(), product.getStatus());
			if(productInfoAll.size() > 0) {
				pageInfo.setCountPage(productInfoAll.size()); // 总行数
			}else {
				pageInfo.setCountPage(1);
			}
			List<TProduct> productInfo = indexMapper.findProductByTitleOrStatus(product.getProductName(), product.getStatus(), pageInfo.getStartIndex(), pageInfo.getShowAmount());
			if(productInfo.size() < 1) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
			}else {
				resp.setCode("000000");
				resp.setMessage("成功");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productInfo", productInfo);
			map.put("pageInfo", pageInfo);
			resp.setData(map);
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
	public BaseDataResp showProblemInfo(@RequestBody ProductAndPageInfo findInfo) {
		BaseDataResp resp = new BaseDataResp();
		PageInfo pageInfo = setPageInfo(findInfo.getPageCurrent());
		if(findInfo.getProductName() == "" && findInfo.getStatus() == "") {
			List<TProblem> allProblem = problemMapper.showAllProblem();
			if(allProblem.size() > 0) {
				pageInfo.setCountPage(allProblem.size());
			}else {
				pageInfo.setCountPage(1);
			}
			List<TProblem> list = problemMapper.showProblems(pageInfo.getStartIndex(), pageInfo.getShowAmount());
			if(list.size() < 1) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
			}else {
				resp.setCode("000000");
				resp.setMessage("成功");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("problemInfo", list);
			map.put("pageInfo", pageInfo);
			resp.setData(map);
			return resp;
		}else {
			List<TProblem> problemAll = problemMapper.findProblemByTitleOrStatuAll(findInfo.getProductName(), findInfo.getStatus());
			if(problemAll.size() > 0) {
				pageInfo.setCountPage(problemAll.size());
			}else {
				pageInfo.setCountPage(1);
			}
			List<TProblem> list = problemMapper.findProblemByTitleOrStatus(findInfo.getProductName(), 
					findInfo.getStatus(), 
					pageInfo.getStartIndex(), 
					pageInfo.getShowAmount());
			if(list.size() < 1) {
				resp.setCode("000001");
				resp.setMessage("没有数据");
			}else {
				resp.setCode("000000");
				resp.setMessage("成功");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("problemInfo", list);
			map.put("pageInfo", pageInfo);
			resp.setData(map);
			return resp;
		}
	}
	
	@RequestMapping("showProblemEdit")
	public String showProblemEdit() {
		return "problem/problem_edit";
	}
	
	@RequestMapping("findProblemById")
	@ResponseBody
	public BaseDataResp findProblemById(@RequestParam("id") String id) {
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
