package org.cqipc.edu.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cqipc.edu.bean.T_test;
import org.cqipc.edu.service.T_testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestConntroller {
	@Autowired
	T_testService ts;
	
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

	
		
}
