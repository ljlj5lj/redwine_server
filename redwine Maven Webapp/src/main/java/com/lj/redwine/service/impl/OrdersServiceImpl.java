package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.OrdersDao;
import com.lj.redwine.pojo.OrderStatus;
import com.lj.redwine.pojo.Orders;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	
	@Resource
	private OrdersDao ordersDao;


	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		this.ordersDao.addOrders(orders);
	}

	public Orders queryOrdersById(int id) {
		// TODO Auto-generated method stub
		return this.ordersDao.queryOrdersById(id);
	}

	public void deleteOrders(int id) {
		// TODO Auto-generated method stub
		this.ordersDao.deleteOrders(id);
	}

	public User queryUserByOrderId(int id) {
		// TODO Auto-generated method stub
		return this.ordersDao.queryUserByOrderId(id);
	}

	public OrderStatus queryOrderStatusByOrderId(int id) {
		// TODO Auto-generated method stub
		return this.ordersDao.queryOrderStatusByOrderId(id);
	}


	public Orders queryOrderItemByOrderId(int id) {
		// TODO Auto-generated method stub
		return this.ordersDao.queryOrderItemByOrderId(id);
	}

	public List<Orders> findAllOrders() {
		// TODO Auto-generated method stub
		return this.ordersDao.findAllOrders();
	}

	public List<Orders> queryOrderByUserId(int user_id, int id) {
		// TODO Auto-generated method stub
		return this.ordersDao.queryOrderByUserId(user_id, id);
	}

	public boolean removeOrders(int id) {
		// TODO Auto-generated method stub
		return this.ordersDao.removeOrders(id);
	}

	
	
}
