package com.lj.redwine.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.redwine.pojo.ShoppingCart;

public interface ShoppingCartService {
	//根据用户id查询购物车
	public List<ShoppingCart> queryShoppingCartByUserId(int id);
	
	//加入我的购物车
	public boolean addShoppingCart(ShoppingCart shoppingCart);
	
	//删除购物车中的红酒
	public boolean deleteShoppingCart(int id);
	
	//查询红酒在购物车是否存在
	public ShoppingCart findShoppingCart(@Param(value="redwine_id") int redwine_id, @Param(value="user_id") int user_id);
}
