package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.BaseDataResp;
import com.neo.entity.TProblem;
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
		List<TProblem> list = problemMapper.showProblem();
		if(list.size() < 1) {
			resp.setCode("000001");
			resp.setMessage("请求失败！");
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(list);
		return resp;
	}
	
	@RequestMapping("/problemDetails")
	@ResponseBody
	public BaseDataResp showProblemDetails(String problemId) {
		BaseDataResp resp = new BaseDataResp();
		TProblem problem = problemMapper.showProblemDetails(problemId);
		if(problem == null) {
			resp.setCode("000001");
			resp.setMessage("没有内容");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(problem);
		return resp;
	}
}
