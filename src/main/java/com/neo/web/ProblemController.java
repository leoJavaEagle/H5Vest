package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.BaseDataResp;
import com.neo.mapper.ProblemMapper;

@RestController
@RequestMapping("/mine")
public class ProblemController {

	@Autowired
	private ProblemMapper problemMapper;
	
	@RequestMapping("/problem")
	@ResponseBody
	public BaseDataResp showProblem() {
		BaseDataResp resp = new BaseDataResp();
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(problemMapper.showProblem());
		return resp;
	}
	
	@RequestMapping("/problemDetails")
	@ResponseBody
	public BaseDataResp showProblemDetails(String problemId) {
		BaseDataResp resp = new BaseDataResp();
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(problemMapper.showProblemDetails(problemId));
		return resp;
	}
}
