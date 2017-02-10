package com.lj.redwine.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.ShoppingCart;
import com.lj.redwine.service.ShoppingCartService;

@Controller  
@RequestMapping("/shoppingCart")  
public class ShoppingCartController {
	@Resource
	ShoppingCartService shoppingCartService;
	
	@RequestMapping(value="/listShoppingCartByUserId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findShoppingCartByUserId(HttpServletRequest request,int id) {//通过用户id查询购物车
		List<ShoppingCart> shoppingCartList = shoppingCartService.queryShoppingCartByUserId(id);
		return JSON.toJSONString(shoppingCartList);
	}
	
	@RequestMapping("/addShoppingCart")
	@ResponseBody
	public String addShoppingCart(HttpServletRequest request, int user_id, int redwine_id) {//添加至购物车
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCart(redwine_id, user_id);
		if (shoppingCart != null) {
			return "exist";
		} else {
			ShoppingCart shoppingCart1 = new ShoppingCart();
			shoppingCart1.setRedwine_id(redwine_id);
			shoppingCart1.setUser_id(user_id);
			if (shoppingCartService.addShoppingCart(shoppingCart1)) {
				return "success";
			} else {
				return "fail";
			}
		}
		
	}
	
	@RequestMapping(value="/deleteShoppingCart")
	@ResponseBody
	public String deleteShoppingCart(HttpServletRequest request,int id) {//删除购物车中的红酒
		if (shoppingCartService.deleteShoppingCart(id)) {
			return "success";
		} else {
			return "fail";
		}
	}
}
