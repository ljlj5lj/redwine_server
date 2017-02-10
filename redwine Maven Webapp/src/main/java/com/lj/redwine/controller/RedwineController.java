package com.lj.redwine.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.RedwineType;
import com.lj.redwine.service.RedwineService;
import com.lj.redwine.service.RedwineTypeService;

@Controller  
@RequestMapping("/redwine")  
public class RedwineController {
	@Resource
	RedwineService redwineService;
	@Resource
	RedwineTypeService redwineTypeService;
	
	@RequestMapping(value="/listRedwine", method=RequestMethod.GET)
	public String findAllRedwine(HttpServletRequest request, Model model) {//显示所有红酒
		List<Redwine> redwineList = redwineService.findAllRedWine();
		model.addAttribute("redwineList", redwineList);
		return "redwine/listRedwine";
	}
	
	@RequestMapping("/deleteRedwine")
	public String deleteRedwine(int id, HttpServletRequest request, HttpServletResponse response) {//删除红酒
		if (redwineService.deleteRedWine(id)) {
			return "operation/success";
		}else {
			return "operation/fail";
		}
	}
	
	@RequestMapping(value="/addRedwineInput", method=RequestMethod.GET)
	public String addRedwineInput(HttpServletRequest request, Model model){//添加红酒信息入口
		List<RedwineType> redwineTypeList = redwineTypeService.findAllRedWineType();
		model.addAttribute("redwineTypeList", redwineTypeList);
		return "redwine/addRedwine";
	}

	@RequestMapping("/addRedwine")
	public String addRedwine(MultipartFile file, HttpServletRequest request, Model model, @Valid Redwine redwine, BindingResult result) {//添加红酒信息
		if (file!=null) {// 判断上传的文件是否为空
			String type = null;// 文件类型
			String fileName=file.getOriginalFilename();// 文件原名称
			type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
			if (type!=null) {// 判断文件类型是否为空
				if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())){//判断文件类型是否为图片类型
					// 项目在容器中实际发布运行的根路径
					String realpath = request.getSession().getServletContext().getRealPath("/redwine_img");
					try {
						//上传图片至根路径
						FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realpath,file.getOriginalFilename()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				    if (result.hasErrors()) {  
				    	List<RedwineType> redwineTypeList = redwineTypeService.findAllRedWineType();
						model.addAttribute("redwineTypeList", redwineTypeList);
				        return "/redwine/addRedwine";  
				    }  else {
						Date date = new Date();//获取系统当前时间
						redwine.setRegister_date(date);
						redwine.setPicture(file.getOriginalFilename());
						redwineService.addRedWine(redwine);
						return "redirect:/redwine/listRedwine";
					}
					
				} else {
					model.addAttribute("message", "文件类型不是图片,请按要求重新上传");
					List<RedwineType> redwineTypeList = redwineTypeService.findAllRedWineType();
					model.addAttribute("redwineTypeList", redwineTypeList);
					System.out.println("文件类型不是图片,请按要求重新上传");
					return "/redwine/addRedwine";
				}
				
			} else {
				System.out.println("文件类型不能为空");
				List<RedwineType> redwineTypeList = redwineTypeService.findAllRedWineType();
				model.addAttribute("redwineTypeList", redwineTypeList);
				model.addAttribute("message", "文件类型不能为空");
				return "/redwine/addRedwine";
			}
		} else {
			List<RedwineType> redwineTypeList = redwineTypeService.findAllRedWineType();
			model.addAttribute("redwineTypeList", redwineTypeList);
			model.addAttribute("message", "没有找到相对应的文件");
			System.out.println("没有找到相对应的文件");
			return "/redwine/addRedwine";
		}
	}
	
	@RequestMapping("/showRedwine")
	public String findRedwine(int id, HttpServletRequest request, Model model) { //查看红酒信息
		String realpath = "/redwine_img";//服务器所在路径
		model.addAttribute("realpath", realpath);
		model.addAttribute("redwine", redwineService.queryRedWineById(id));
		return "redwine/showRedwine";
	}
	
	@RequestMapping(value="/editRedwineInput", method=RequestMethod.GET)
	public String editRedwineInput(int id, HttpServletRequest request, Model model) {//修改红酒信息入口
		model.addAttribute("redwineTypeList", redwineTypeService.findAllRedWineType());
		model.addAttribute("redwine", redwineService.searchRedWineById(id));
		model.addAttribute("r", redwineService.queryRedWineById(id));
		return "redwine/editRedwine";
	}
	
	@RequestMapping(value="/editRedwine")
	public String editRedwine(HttpServletRequest request, Redwine redwine, Model model) {//修改红酒信息
		redwineService.updateRedWine(redwine);
		return "redirect:/redwine/listRedwine";
	}
	
	@RequestMapping(value="/queryRedwineById",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String queryRedwineById(int id,HttpServletRequest request) {//通过id查找红酒
		Redwine redwine = redwineService.queryRedWineById(id);
		return JSON.toJSONString(redwine);
	}
	
	@RequestMapping(value="/listRedwineOrderByTime",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findRedwineOrderByTime(HttpServletRequest request,int id) {//按上架日期查询红酒
		List<Redwine> redwineList = redwineService.queryRedwineOrderByTime(id);
		return JSON.toJSONString(redwineList);
	}
	
	@RequestMapping(value="/listRedwineOrderBySales",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findRedwineOrderBySales(HttpServletRequest request,int id) {//按销量查询红酒
		List<Redwine> redwineList = redwineService.queryRedwineOrderBySales(id);
		return JSON.toJSONString(redwineList);
	}
	
	@RequestMapping(value="/listRedwineOrderById",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findRedwineOrderById(HttpServletRequest request,int id,@RequestParam Map<String, String> map){//模糊查询红酒
		List<Redwine> redwineList = redwineService.searchRedwineOrderById(id, map.get("name"));
		return JSON.toJSONString(redwineList);
	}
	
	@RequestMapping(value="/listRedwineByType",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findRedwineByType(HttpServletRequest request,int id,int redwine_type_id) {//按上架日期查询红酒
		System.out.println(redwine_type_id);
		List<Redwine> redwineList = redwineService.queryRedWineByType(id, redwine_type_id);
		return JSON.toJSONString(redwineList);
	}
}
