package org.cqipc.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import com.alibaba.fastjson.JSONObject;
import javafx.scene.input.DataFormat;
import org.apache.ibatis.annotations.Param;
import org.cqipc.edu.bean.*;
import org.cqipc.edu.service.T_userService;
import org.cqipc.edu.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@SessionAttributes("LoginParams")

public class UserController {
	@Autowired
	T_userService ts;
	@SystemControllerLog(description = "用户登录")
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
		}else if(param[0]=="error1"){
			par[0]="您在系统中的权限未完善，不能登录！如要登录，请联系管理员!";
			return par;
		} else  {
			model.addAttribute("LoginParams", param);
			System.out.println("*****测试model");
			Object[] p= (Object[]) model.getAttribute("LoginParams");
			System.out.println(p[0]);

//			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
//			HttpServletRequest request1 = ((ServletRequestAttributes)requestAttributes).getRequest();
//			HttpSession session = request1.getSession();
//			session.setAttribute("LoginParams",param);
//			Object[] param1=(Object[])session.getAttribute("param");
//			//T_user user = (T_user)session.getAttribute("param");
//			System.out.println("-------打印param--------");
//			System.out.println(param1[0]);
//			//System.out.println(user);
//			System.out.println("打印结束");
			par[0]="ok";
			return par;
		}
	}
	@SystemControllerLog(description = "登录成功")
	@RequestMapping("/loginSuccess")
	@ResponseBody
	public Object[] loginSuccess(HttpSession session) {
		//由于在上一个URL中已经保存了登录信息在session中，所以此时直接从session中获取值，由此可见，SpringMVC的
		//session和servletAPI中的session是同一个
		Object[] param=(Object[])session.getAttribute("LoginParams");
		System.out.println("打印param");
		System.out.println(param);
		System.out.println("打印结束");
		return param;
	}


	@SystemControllerLog(description = "添加用户")
	@RequestMapping("/adduser")
	@ResponseBody
	public int adduser(
			   T_user t_user,
			@RequestParam("totalage")int totalage,
			@RequestParam("user_c_id")BigInteger user_c_id

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

		//T_user t_user=new T_user();
//		int totalage=100;
//		BigInteger user_c_id=BigInteger.valueOf(5);
		System.out.println(t_user);
		System.out.println(totalage+"  "+user_c_id);
		//将密码进行MD5加密
		System.out.println("1");
		String pwd=t_user.getPassword();
		t_user.setPassword(MD5.getMd5(pwd));

		String data=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		t_user.setCreate_time(data);
		int count=ts.adduser(t_user);

		System.out.println("新增数据的主键 :" + t_user.getUser_id());
		T_mingjie_lifeanddie t_mingjie_lifeanddie=new T_mingjie_lifeanddie(null,t_user,data,0,totalage,totalage,1);
		T_plife t_plife=new T_plife(1,1,t_user.getUser_id(),"",data,user_c_id);


		if(count>0&&ts.addLifeAndDie(t_mingjie_lifeanddie)>0&&ts.addPlife(t_plife)>0){
			return 1;
		}else {
			return 2;
		}

	}
	@SystemControllerLog(description = "select")
	@RequestMapping("/selectDeptAll")
	@ResponseBody
	public List<T_dept> selectDeptAll(){
		return ts.selectDeptAll();
	}
	//查询死溥中 状态为1 的人 且能转世的人
	@SystemControllerLog(description = "select")
	@RequestMapping("/selectUserDie")
	@ResponseBody
	public List<T_user> selectUserDie(){
		return ts.selectUserDie();
	}

	@SystemControllerLog(description = "select")
	@RequestMapping("/selectUserInfoAll")
	@ResponseBody
	public Map<String,Object> selectUserInfoAll(@RequestParam(required = false,defaultValue = "0",value = "user_id") int user_id,
												@RequestParam(required = false,defaultValue = "",value = "username") String username,
												@RequestParam(required = false,defaultValue = "1")int page,
												@RequestParam(required = false,defaultValue = "10")int limit){

		List<T_user_ov> list=null;
		int count=0;
		if(user_id!=0){
			list=ts.selectLifeAndDie(user_id,"",page,limit);
			count=ts.selectLifeAndDieCount(user_id,"");
		}else if(username!=""&&username!=null){
			list=ts.selectLifeAndDie(0,username,page,limit);
			count=ts.selectLifeAndDieCount(0,username);
		}else {
			list=ts.selectLifeAndDie(0,"",page,limit);
			count=ts.selectLifeAndDieCount(0,"");
		}
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("code",0);
			map.put("msg","");
			map.put("count",count);
			map.put("data",list);

	return 	map;
	}

	//死簿查询
	@SystemControllerLog(description = "select")
	@RequestMapping("selectUserDieAll")
	@ResponseBody
	public Map<String,Object> selectUserDieAll(@RequestParam(required = false,defaultValue = "0",value = "user_id") int user_id,
											   @RequestParam(required = false,defaultValue = "",value = "username") String username,
											   @RequestParam(required = false,defaultValue = "1")int page,
											   @RequestParam(required = false,defaultValue = "10")int limit){
		List<T_user> list=null;
		int count=0;
		if(user_id!=0){
			list=ts.selectUserDieAll(user_id,"",page,limit);
			count=ts.selectUserDieCount(user_id,"");
		}else if(username!=""&&username!=null){
			list=ts.selectUserDieAll(0,username,page,limit);
			count=ts.selectUserDieCount(0,username);
		}else {
			list=ts.selectUserDieAll(0,"",page,limit);
			count=ts.selectUserDieCount(0,"");
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		map.put("data",list);
		return 	map;
	}
	//查询用户死亡待确认名单
	@SystemControllerLog(description = "select")
	@RequestMapping("/userdie")
	@ResponseBody
	public  Map<String,Object> userdie(){
		List<T_user_ov> list=ts.userdie();
		int count=ts.userdieCount();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		map.put("data",list);
		return 	map;
	}

	//待确认人员 从生簿到死簿
	@SystemControllerLog(description = "确认死亡")
	@RequestMapping("/RemoveAndAdd")
	@ResponseBody
	public int  RemoveAndAdd(@RequestParam(value = "user_id[]")int[] user_id){
		System.out.println(user_id.length);
		List<BigInteger> list1=new ArrayList<>();
		for(int i=0;i<user_id.length;i++){
			list1.add(BigInteger.valueOf(user_id[i]));
		}
		System.out.println(list1);
		int count1=ts.removeUser(list1);
		List<T_user> list2=ts.selectUserConfirmed(list1);
		String date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		for(T_user c:list2){
			c.setCreate_time(date);
		}
		System.out.println(list2);

		T_user t_user1=new T_user(BigInteger.valueOf(100),"张三","123131",BigInteger.valueOf(2),null,null,1,date,date,null,"男",null,null,0);
		T_user t_user2=new T_user(BigInteger.valueOf(101),"李四","123131",BigInteger.valueOf(2),null,null,1,date,date,null,"男",null,null,0);
		List<T_user> list=new ArrayList<>();
		list.add(t_user1);
		list.add(t_user2);
		//System.out.println(list);
		int count=ts.addToUser_c(list2);
		if (count!=0&&count1!=0){
			return 1;
		}else {
			return 2;
		}
	}


	//待审判
	@SystemControllerLog(description = "select")
	@RequestMapping("/selectApprove")
	@ResponseBody
	public  Map<String,Object> selectApprove(@RequestParam(required = false,value = "page",defaultValue = "1")int page,
											 @RequestParam(required = false,defaultValue = "10",value = "limit")int limit){
		List<T_user_ov> list=ts.selectApprove(page,limit);
		int count=ts.selectApproveCount();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",count);
		map.put("data",list);
		return 	map;
	}


	//监狱
	@SystemControllerLog(description = "添加地狱")
	@RequestMapping("/addJail")
	@ResponseBody
	public int addJail(T_mingjie_eighteen t_mingjie_eighteen){
		int count=ts.addJail(t_mingjie_eighteen);
		if(count!=0){
			return 1;
		}else {
			return 2;
		}
	}

	@SystemControllerLog(description = "关入地狱")
	@RequestMapping("/inJail")
	@ResponseBody
	public int inJail(T_mingjie_eighteen_log t_mingjie_eighteen_log){
		int count=ts.inJail(t_mingjie_eighteen_log);
		if(count!=0){
			return 1;
		}else {
			return 2;
		}
	}

	//
	@SystemControllerLog(description = "select")
	@RequestMapping("/selectJail")
	@ResponseBody
	public List<T_mingjie_eighteen> selectJail(){
		return ts.selectJail();
	}
}
