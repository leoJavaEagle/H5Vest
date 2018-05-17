package com.neo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public BaseDataResp checkLogin(@RequestBody UserBean util, HttpServletRequest request, HttpServletResponse response) {
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
		HttpSession session = request.getSession(true);
		session.setAttribute("username", user.getUsername());
		session.setAttribute("userId", user.getId());
		return resp;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("userId");
		return "login";
	}
	
}
