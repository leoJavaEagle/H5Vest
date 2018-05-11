package com.neo.web;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.UserEntity;
import com.neo.mapper.LoginMapper;

@Controller
@RequestMapping("/console")
public class LoginController {
	
	@Autowired
	private LoginMapper loginMapper;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/checkLogin", method=RequestMethod.GET)
	@ResponseBody
	public String checkLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		System.out.println(userName + ",  " + password);
		System.out.println(">>>>>12345");
		BaseDataResp resp = new BaseDataResp();
		UserEntity user = loginMapper.userLogin(userName, password);
		System.out.println(">>>>>12345");
		if(user == null) {
			resp.setCode("0001");
			resp.setMessage("没有此人");
		}
		resp.setCode("0000");
		resp.setMessage("成功");
		resp.setDate(user);
		return "redirect:/home";
	}
	
}
