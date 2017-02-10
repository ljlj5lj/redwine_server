package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.ShoppingCartDao;
import com.lj.redwine.pojo.ShoppingCart;
import com.lj.redwine.service.ShoppingCartService;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Resource
	ShoppingCartDao shoppingCartDao;
	
	public List<ShoppingCart> queryShoppingCartByUserId(int id) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.queryShoppingCartByUserId(id);
	}

	public boolean addShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.addShoppingCart(shoppingCart);
	}

	public boolean deleteShoppingCart(int id) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.deleteShoppingCart(id);
	}

	public ShoppingCart findShoppingCart(int redwine_id, int user_id) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.findShoppingCart(redwine_id, user_id);
	}
	
}
