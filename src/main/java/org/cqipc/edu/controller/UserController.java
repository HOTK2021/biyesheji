package org.cqipc.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import javafx.scene.input.DataFormat;
import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.T_dept;
import org.cqipc.edu.bean.T_user;
import org.cqipc.edu.service.T_userService;
import org.cqipc.edu.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@SessionAttributes("LoginParams")
public class UserController {
	@Autowired(required = false)
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
		System.out.println(MD5.getMd5(password));
		Object[] param=ts.Login(username, password);
		Object[] par=new Object[1];
		request.getSession();
		if(param[0]=="error") {
			par[0]="用户名或者密码错误";
			return par;
		}else if(param[0]=="not"){
			par[0]="您不是公职人员，不能登录！";
			return par;
		}else {
			model.addAttribute("LoginParams", param);
			par[0]="ok";
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

	@RequestMapping("addduser")
	@ResponseBody
	public String adduser(
			T_user t_user
//			@RequestParam("username")String username,
//			@RequestParam("password")String password,
//			@RequestParam("dept_id") BigInteger dept_id,
//			@RequestParam("email")String email,
//			@RequestParam("mobile")String mobile,
//			@RequestParam("status")int status,
//			@RequestParam("create_time")String create_time,
//			@RequestParam("modify_time")String modify_time,
//			@RequestParam("last_login_time")String last_login_time,
//			@RequestParam("ssex")String ssex,
//			@RequestParam("description")String description,
//			@RequestParam("avatar")String avatar,
//			@RequestParam("age")int age,
//			@RequestParam("lifetime")int lifetime
			){
		//T_user t_user=new T_user(username,password,dept_id,email,mobile,status,create_time,modify_time,last_login_time,
		//		ssex,description,avatar,age,lifetime);
		String data=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

		T_user t_user1=new T_user("张三","12323",BigInteger.valueOf(5),"1","12312",1,data,data,data,
				"0","1","2",12,99);
		System.out.println(t_user1);
		if(ts.adduser(t_user1)>0){
			System.out.println(t_user1);
			return "ok";
		}else {
			return "no";
		}
	}
	@RequestMapping("/electDeptAll")
	@ResponseBody
	public List<T_dept> selectDeptAll(){
		return ts.selectDeptAll();
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
