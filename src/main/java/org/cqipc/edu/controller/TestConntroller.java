package org.cqipc.edu.controller;



import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cqipc.edu.bean.T_mingjie_lifeanddie;
import org.cqipc.edu.bean.T_plife;
import org.cqipc.edu.bean.T_test;
import org.cqipc.edu.bean.T_user;
import org.cqipc.edu.service.T_testService;
import org.cqipc.edu.service.T_userService;
import org.cqipc.edu.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestConntroller {
	@Autowired
	T_testService ts;
	@Autowired
	T_userService tus;

    @RequestMapping("/showData")
    @ResponseBody
	public Map<String,Object> showData(@RequestParam(required=false,defaultValue="1") int page,
            @RequestParam(required=false,defaultValue="15") int limit,
            String keyWord){
		List<T_test> datas=ts.selectTestAll(page, limit, keyWord);
		int countx=ts.queryCount(keyWord);
		Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",countx);
        map.put("data",datas);
		return map;
	}

	@RequestMapping("/insertTest")
	@ResponseBody
	public void insertTest()  {
		T_test t_test = new T_test();
		t_test.setField1("新增得到主键5");
		t_test.setField2(12345);
		t_test.setField3("哈哈");
		String data=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		t_test.setCreate_time(data);
		ts.insertTest(t_test);
		// 获取新增数据主键
		System.out.println("新增数据的主键 :" + t_test.getId());
	}

//	@RequestMapping("addUser")
//	@ResponseBody
//	public String addUser(T_user t_user,
//						@RequestParam("totalage")int totalage,
//						@RequestParam("user_c_id") BigInteger user_c_id){
//		System.out.println(t_user);
//		System.out.println(totalage+"  "+user_c_id);
//		//将密码进行MD5加密
//		System.out.println("1");
//		String pwd=t_user.getPassword();
//		//t_user.setPassword(MD5.getMd5(pwd));
//		String data=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
//		t_user.setCreate_time(data);
//		int count=tus.adduser(t_user);
//
//		System.out.println("新增数据的主键 :" + t_user.getUser_id());
//		T_mingjie_lifeanddie t_mingjie_lifeanddie=new T_mingjie_lifeanddie(null,t_user,data,0,totalage,totalage,1);
//		T_plife t_plife=new T_plife(1,1,t_user.getUser_id(),"",data,user_c_id);
//
//
//		if(count>0&&tus.addLifeAndDie(t_mingjie_lifeanddie)>0&&tus.addPlife(t_plife)>0){
//			return "ok";
//		}else {
//			return "no";
//		}
//	}


//
//		System.out.println(totalage+"  "+user_c_id);
//		String pwd=t_user.getPassword();
//		String data=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
//		t_user.setPassword(MD5.getMd5(pwd));
//		t_user.setCreate_time(data);
//		int count=tus.adduser(t_user);
//		System.out.println(t_user.getUser_id());
//
//		T_mingjie_lifeanddie t_mingjie_lifeanddie=new T_mingjie_lifeanddie(null,t_user,data,0,totalage,totalage,1);
//		T_plife t_plife=new T_plife(1,1,t_user.getUser_id(),"",data,user_c_id);
//		System.out.println(t_user);
//		System.out.println(t_mingjie_lifeanddie);
//		System.out.println(t_plife);
//
//	}

}
