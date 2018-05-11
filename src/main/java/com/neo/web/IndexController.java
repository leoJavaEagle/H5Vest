package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
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
		resp.setCode("0000");
		resp.setMessage("成功");
		resp.setDate(indexMapper.showIndex());
		return resp;
	}
	
	@RequestMapping("/showIndexPage")
	public String showIndexPage() {
		return "home";
	}
}
