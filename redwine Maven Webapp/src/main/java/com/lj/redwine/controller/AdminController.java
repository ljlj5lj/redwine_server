package com.lj.redwine.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lj.redwine.pojo.Admin;
import com.lj.redwine.service.AdminService;

@Controller  
@RequestMapping("/admin")  
@SessionAttributes({"admin","admin_name"})
public class AdminController {
	@Resource  
	private AdminService adminService;
	
	@RequestMapping(value="/adminLogin")
	public String adminLogin(HttpServletRequest request,String admin_name, String admin_password, Model model) {//管理员登录
		Admin admin = adminService.adminLogin(admin_name, admin_password);
		if (admin != null) {
			model.addAttribute("admin_name",admin_name);
			return "index";
		} else {
			model.addAttribute("message", "用户名或密码不正确");
			return "login";
		}
	}
	
}
