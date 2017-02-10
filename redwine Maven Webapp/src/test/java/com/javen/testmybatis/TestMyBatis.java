package com.javen.testmybatis;


import javax.annotation.Resource;  
import javax.json.Json;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  





import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.RedwineService;
import com.lj.redwine.service.UserService;

  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  

//  private ApplicationContext ac = null;  
    @Resource  
    private UserService userService = null;  
    @Resource  
    private RedwineService redwineService = null;  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
    	User user = userService.findTelephone("13719109799");
//    	JSON.toJSON(user);
    	if (user != null) {
			System.out.println(JSON.toJSON(user));
		} else {
			System.out.println("null");
		}
    }  
}  