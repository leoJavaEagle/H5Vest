package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.UserEntity;
import com.neo.mapper.LoginMapper;

@Controller
@RequestMapping("/console")
public class LoginController {
	
	@Autowired
	private LoginMapper loginMapper;

	@RequestMapping("/login.do")
	public String login() {
		System.out.println("123456>>>>>>");
		return "login";
	}
	
	@RequestMapping("/checkLogin.do")
	@ResponseBody
	public BaseDataResp checkLogin(String username, String password) {
		BaseDataResp resp = new BaseDataResp();
		UserEntity user = loginMapper.userLogin(username, password);
		if(user == null) {
			resp.setCode("0001");
			resp.setMessage("没有此人");
			return resp;
		}
		resp.setCode("0000");
		resp.setMessage("成功");
		resp.setDate(user);
		return resp;
	}
	
}
