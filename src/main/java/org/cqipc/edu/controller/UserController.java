package org.cqipc.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.cqipc.edu.service.T_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("LoginParams")
public class UserController {
	@Autowired
	T_userService ts;
	

	@RequestMapping("userLogin")
	@ResponseBody
	public Object[] userLogin(@RequestParam("username")String username,
			@RequestParam("password")String password,Model model,HttpServletRequest request) {
		/*
		 * username和password是正常的参数
		 * 由于使用的是ajax提交，因此必须返回到回调函数，但如果成功登录需要将登录信息保存在session中
		 * 因此需要使用model对象来使springMVC的session所识别，这里的name名称即key值必须一致
		 * 
		 * 又由于此操作是一个response操作，在ajax重新定向到下一个URL之后sessionID已经找不到了，所以要在返回
		 * 值之前通过request get出session
		 * */
		System.out.println(username);
		Object[] param=ts.Login(username, password);
		Object[] par=new Object[1];
		request.getSession();
		if(param[0]!="error") {
			model.addAttribute("LoginParams", param);
			par[0]="ok";
			return par;
		}else {
			par[0]="用户名或者密码错误";
			return par;
		}
	}
	@RequestMapping("loginSuccess")
	@ResponseBody
	public Object[] loginSuccess(HttpSession session) {
		//由于在上一个URL中已经保存了登录信息在session中，所以此时直接从session中获取值，由此可见，SpringMVC的
		//session和servletAPI中的session是同一个
		Object[] param=(Object[])session.getAttribute("LoginParams");
		System.out.println(param);
		return param;
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
