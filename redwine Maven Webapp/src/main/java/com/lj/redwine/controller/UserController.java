package com.lj.redwine.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {
	@Resource  
	private UserService userService;     
	
	@RequestMapping(value="/listUser",method=RequestMethod.GET)
	public String findAllUser(HttpServletRequest request, Model model) {//显示所有用户信息
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "user/listUser";
	}
	
	@RequestMapping(value="/chatting")
	public String chatting(HttpServletRequest request, Model model) {
		return "chatting/webSocketChatting";
	}
	
	@RequestMapping(value="/findTelephone")
	@ResponseBody
	public String findTelephone(HttpServletRequest request,String telephone,Model model) {//查询是否存在的手机号码
		User user = userService.findTelephone(telephone);
		//System.out.println(JSON.toJSONString(user));
		if (user != null) {
			return "exsit";
		}else {
			return "no_exsit";
		}
	}
	
	@RequestMapping(value="/updateUsername")
	@ResponseBody
	public String updateUsername(HttpServletRequest request,@RequestParam Map<String, String> map,int id) {//更新用户名
		User user = userService.findUsername(map.get("username"));
		if (user != null) {
			return "exsit";
		} else {
			if (userService.updateUsername(map.get("username"), id)) {
				return "success";
			} else {
				return "fail";
			}
			
		}
	}
	
	@RequestMapping(value="/updatePassword")
	@ResponseBody
	public String updatePassword(HttpServletRequest request,@RequestBody Map<String, String> map,int id) {//更新密码
		User user = userService.queryUserById(id);
		user.setPassword(map.get("password"));
		userService.updateUser(user);
		return JSON.toJSONString(user);
	}
	
	@RequestMapping(value="/accountLogin")
	@ResponseBody
	public String accountLogin(HttpServletRequest request,@RequestParam(value="username") String username,@RequestParam(value="password") String password) {//账号密码登录
		User user = userService.findUserByAccount(username, password);
		if (user != null) {
			return JSON.toJSONString(user);
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value="/telephoneLogin")
	@ResponseBody
	public String telephoneLogin(HttpServletRequest request,String telephone) { //手机号码登录
		User user = userService.findUserByTelephone(telephone);
		return JSON.toJSONString(user);
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(HttpServletRequest request, @RequestBody Map<String, String> map) {//注册用户
		User user = new User();
		user.setPassword(map.get("password"));
		user.setTelephone(map.get("telephone"));
		user.setUsername("user_"+map.get("telephone"));		
		if (userService.addUser(user)) {
			return JSON.toJSONString(user);
		}else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/findUserById")
	@ResponseBody
	public String findUserById(int id,HttpServletRequest request) {//通过id查找用户
		User user = userService.queryUserById(id);
		return JSON.toJSONString(user);
	}
	
	@RequestMapping(value="/uploadAvatar")
	@ResponseBody
	public String uploadAvatar(int id,HttpServletRequest request,@RequestBody Map<String, String> map) {//上传图片
		String realpath = request.getSession().getServletContext().getRealPath("/user_avatar");//服务器路径
		String imageString = map.get("imageString");//图片转的字符串
		String imageName = map.get("imageName");//图片名
		try {
			byteStringtoImage(imageString, realpath, imageName);//将上存的图片保存至服务器路径下
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = userService.queryUserById(id);
		user.setAvatar(imageName+".jpg");
		userService.updateUserAvatarById(user);
		return JSON.toJSONString(user);
	}
	
	public void byteStringtoImage(String s,String path,String imageName) throws IOException {//将上存的图片保存至服务器路径下
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(s);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
		File file = new File(path+"/"+imageName+".jpg");
		ImageIO.write(bufferedImage, "jpg", file);
	}
}
