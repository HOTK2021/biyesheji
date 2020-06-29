package org.cqipc.edu.controller;

import org.cqipc.edu.bean.*;
import org.cqipc.edu.service.SystemService;
import org.cqipc.edu.service.T_job_logService;
import org.cqipc.edu.service.T_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SystemController {
    @Autowired
    SystemService ss;
    @Autowired
    T_userService ts;
    @Autowired
    T_job_logService tjl;


    @SystemControllerLog(description = "select")
    @RequestMapping("/selectPlauge")
    @ResponseBody
    public List<T_plague> selectPlauge(){
        return ss.selectPlauge();
    }

    @SystemControllerLog(description = "select")
    @RequestMapping("/selectPlaugeInfo")
    @ResponseBody
    public Map<String,Object> selectPlaugeInfo(){
        List<T_plague_info> list=ss.selectPlaugeInfo();
        int count=ss.selectPlaugeInfoCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        map.put("count",count);
        return map;
    }

    @SystemControllerLog(description = "select")
    @RequestMapping("/selectUserToPlague")
    @ResponseBody
    public List<T_user> selectUserToPlauge(){
        return ss.selectUserToPlauge();
    }


    //确认发布瘟疫
    @SystemControllerLog(description = "发布瘟疫")
    @RequestMapping("/subPlague")
    @ResponseBody
    public int subPlague(T_plague_info t_plague_info){
        //从生簿中随机选择人员
        List<T_user> list=ss.selectUserToPlauge();
        int count=ss.selectPlaugeInfoCount();
        List<T_user> t_user=ts.selectUserAll((t_plague_info.getUser_id()).intValue(),"",1,1);
        T_user user=new T_user();
        user=t_user.get(0);
        System.out.println(user);

        List<BigInteger> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add( list.get(i).getUser_id());
        }
        //将传播者的id从 查出的所有可操作人员中删除，避免随机道自己
        list1.remove(user.getUser_id());
        System.out.println(list1);
        //从list1中随机选择数值
        Collections.shuffle(list1);
        // int randomSeriesLength = 20;
        List<BigInteger> randomSeries = list1.subList(0, t_plague_info.getDie_count()-1);

        //随机后再将传播者id插入
        randomSeries.add(user.getUser_id());
        System.out.println(randomSeries);
        //将选中的从生簿中删除 并且加入死簿
        List<BigInteger> l2=new ArrayList<>();
        for (int i=0;i<randomSeries.size();i++){
            l2.add(randomSeries.get(i));
        }
        System.out.println(l2);

        int count1=ts.removeUser(randomSeries);
        List<T_user> list2=ss.selectUser1(l2);
        String date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        for(T_user c:list2){
            c.setCreate_time(date);
            c.setDescription("瘟疫");
        }
        System.out.println(list2);
        int count2=ts.addToUser_c(list2);

        //向瘟疫记录表中添加数据
        int countPlague=ss.addPlague(t_plague_info);
        //向t_plague_user表中添加死亡人员信息
        List<T_plague_user> list4=new ArrayList<>();
        for (int i=0;i<t_plague_info.getDie_count();i++){
            list4.add(new T_plague_user(null,list2.get(i).getUser_id(),list2.get(i).getUsername(),t_plague_info.getPlague_info_id()));
        }
        int countPU=ss.addPlagueUser(list4);

        //向trial表中 添加待审判的数据
        List<T_mingjie_trial> list3=new ArrayList<>();
        for(int i=0;i<t_plague_info.getDie_count();i++){
            list3.add(new T_mingjie_trial(null,list2.get(i).getUser_id(),BigInteger.valueOf(0),null,null,0,0));
        }
        System.out.println(list3);
        int count3=ts.addIntoTrial(list3);
        if (count2!=0&&count1!=0&&count3!=0){
            return 1;
        }else {
            return 2;
        }
    }

    //查询瘟疫死亡人员名单     传参-plague_info_id plague_info表中瘟疫信息的id
    @SystemControllerLog(description = "select")
    @RequestMapping("/selectPlagueUser")
    @ResponseBody
    public Map<String,Object>selectPlagueUser(int plague_info_id){
        List<T_plague_user> list=ss.selectPlagueUser(plague_info_id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        return map;
    }

    @SystemControllerLog (description = "测试")
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("name") String name,@RequestParam("sex") String sex){
        return "信息="+name+sex;
    }

    //查询操作日志
    @SystemControllerLog(description = "select")
    @RequestMapping("/selectJobLog")
    @ResponseBody
    public Map<String,Object>selectJobLog(){
       List<T_job_log> list=tjl.selectJobLog();
       int count=tjl.selectJobLogCount();
       Map<String,Object> map=new HashMap<String, Object>();
       map.put("code",0);
       map.put("msg","");
       map.put("data",list);
       map.put("count",count);
       return map;
    }

    //查询登录日志
    @SystemControllerLog(description = "select")
    @RequestMapping("/selectLoginLog")
    @ResponseBody
    public Map<String,Object>selectLoginLog(){
        List<T_login_log> list=tjl.selectLoginLog();
        int count=tjl.selectLoginLogCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        map.put("count",count);
        return map;
    }

}
