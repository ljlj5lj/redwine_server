package com.lj.redwine.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lj.redwine.pojo.RedwineType;
import com.lj.redwine.service.RedwineTypeService;

@Controller  
@RequestMapping("/redwineType")  
public class RedwineTypeController {
	@Resource
	RedwineTypeService redwineTypeService;
	
	@RequestMapping(value="/listRedwineType", method=RequestMethod.GET)
	public String findAllRedwine(HttpServletRequest request, Model model) {//显示所有红酒类型
		List<RedwineType> redwineTypeList = redwineTypeService.findAllRedWineType();
		model.addAttribute("redwineTypeList", redwineTypeList);
		return "redwine_type/listRedwineType";
	}
	
	@RequestMapping(value="/editRedwineType")
	public String editRedwineType(HttpServletRequest request, RedwineType redwineType) {//修改红酒信类型
		redwineTypeService.updateRedwineType(redwineType);
		return "redirect:/redwineType/listRedwineType";
	}
	
	@RequestMapping(value="/editRedwineTypeInput", method=RequestMethod.GET)
	public String editRedwineType(int id, HttpServletRequest request, Model model) {//修改红酒类型入口
		model.addAttribute("redwineType", redwineTypeService.queryRedwineTypeById(id));
		return "redwine_type/editRedwineType";
	}
	
	@RequestMapping(value="/addRedwineTypeInput", method=RequestMethod.GET)
	public String addRedwineType(HttpServletRequest request) {//添加红酒类型入口
		return "redwine_type/addRedwineType";
	}
	
	@RequestMapping(value="/addRedwineType")
	public String addRedwineType(HttpServletRequest request, RedwineType redwineType) {//添加红酒类型
		redwineTypeService.addRedwineType(redwineType);
		return "redirect:/redwineType/listRedwineType";
	}
}
