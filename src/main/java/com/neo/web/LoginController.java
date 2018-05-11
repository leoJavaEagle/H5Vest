package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.BaseDataResp;
import com.neo.entity.User;
import com.neo.mapper.LoginMapper;
import com.neo.req.UserBean;

@Controller
@RequestMapping("/console")
public class LoginController {
	
	@Autowired
	private LoginMapper loginMapper;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/checkLogin")
	@ResponseBody
	public BaseDataResp checkLogin(@RequestBody UserBean util) {
		BaseDataResp resp = new BaseDataResp();
		User user = loginMapper.userLogin(util.getUsername(), util.getPassword());
		if(user == null) {
			resp.setCode("000001");
			resp.setMessage("没有此人");
			return resp;
		}
		resp.setCode("000000");
		resp.setMessage("成功");
		resp.setData(user);
		return resp;
	}
	
}


//2018-05-11 17:03:46.299  WARN 7300 --- [nio-8080-exec-3] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved exception caused by Handler execution: org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
