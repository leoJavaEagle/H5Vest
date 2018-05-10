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
	
	@RequestMapping("/problem.do")
	@ResponseBody
	public BaseDataResp showProblem() {
		BaseDataResp resp = new BaseDataResp();
		resp.setCode("0000");
		resp.setMessage("成功");
		resp.setDate(problemMapper.showProblem());
		return resp;
	}
	
	@RequestMapping("/problem/details.do")
	@ResponseBody
	public BaseDataResp showProblemDetails(String problemId) {
		BaseDataResp resp = new BaseDataResp();
		resp.setCode("0000");
		resp.setMessage("成功");
		resp.setDate(problemMapper.showProblemDetails(problemId));
		return resp;
	}
}
