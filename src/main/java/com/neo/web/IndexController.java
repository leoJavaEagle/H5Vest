package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TProduct;
import com.neo.mapper.IndexMapper;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private IndexMapper indexMapper;

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
}
