package com.lj.redwine.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.service.FavoritesService;

@Controller  
@RequestMapping("/favorites")  
public class FavoritesController {
	@Resource
	FavoritesService favoritesService;
	
	@RequestMapping(value="/listFavorites", method=RequestMethod.GET)
	public String findAllFavorites(HttpServletRequest request, Model model) {//显示所有用户收藏
		List<Favorites> favoritesList = favoritesService.findAllFavorites();
		model.addAttribute("favoritesList", favoritesList);
		return "favorites/listFavorites";
	}
	
	@RequestMapping(value="/listFavoritesByUserId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findFavoritesByUserId(HttpServletRequest request,int id) {//通过用户id查询我的收藏
		List<Favorites> favoritesList = favoritesService.queryFavoritesByUserId(id);
		return JSON.toJSONString(favoritesList);
	}
	
	@RequestMapping("/addFavorites")
	@ResponseBody
	public String addFavorites(HttpServletRequest request, int user_id, int redwine_id) {//注册我的收藏
		Favorites favorites = favoritesService.findFavorites(redwine_id, user_id);
		if (favorites != null) {
			return "exist";
		} else {
			Favorites favorites1 = new Favorites();
			favorites1.setRedwine_id(redwine_id);
			favorites1.setUser_id(user_id);
			if (favoritesService.addFavorites(favorites1)) {
				return "success";
			} else {
				return "fail";
			}
		}
		
	}
	
	@RequestMapping(value="/deleteFavorites")
	@ResponseBody
	public String deleteFavorites(HttpServletRequest request,int id) {//删除我的收藏
		if (favoritesService.deleteFavorites(id)) {
			return "success";
		} else {
			return "fail";
		}
	}
}
