package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.User;
import com.neo.mapper.LoginMapper;

@Controller
@RequestMapping("/console")
public class LoginController {
	
	@Autowired
	private LoginMapper loginMapper;

	@RequestMapping("/login")
	public String login() {
		System.out.println("123123");
		return "login";
	}
	
	@RequestMapping("/checkLogin")
	@ResponseBody
	public String checkLogin(@RequestParam("userName") String username, @RequestParam("password") String password) {
		System.out.println(username + ",  " + password);
		BaseDataResp resp = new BaseDataResp();
		User user = loginMapper.userLogin(username, password);
		
//		if(user == null) {
//			resp.setCode("0001");
//			resp.setMessage("没有此人");
//		}
//		resp.setCode("0000");
//		resp.setMessage("成功");
//		resp.setDate(user);
		return "home";
	}
	
}
