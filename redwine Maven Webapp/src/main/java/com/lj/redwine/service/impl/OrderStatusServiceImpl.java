package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.OrderStatusDao;
import com.lj.redwine.pojo.OrderStatus;
import com.lj.redwine.service.OrderStatusService;

@Service("orderStatusService")
public class OrderStatusServiceImpl implements OrderStatusService {
	
	@Resource
	private OrderStatusDao orderStatusDao;
	
	public void addOrderStatus(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		this.orderStatusDao.addOrderStatus(orderStatus);
	}

	public OrderStatus queryOrderStatusById(int id) {
		// TODO Auto-generated method stub
		return this.orderStatusDao.queryOrderStatusById(id);
	}

	public void deleteOrderStatus(int id) {
		// TODO Auto-generated method stub
		this.orderStatusDao.deleteOrderStatus(id);
	}

	public void updateOrderStatus(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		this.orderStatusDao.updateOrderStatus(orderStatus);
	}

	public OrderStatus queryOrdersByOrderStatusId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderStatus> findAllOrderStatus() {
		// TODO Auto-generated method stub
		return this.orderStatusDao.findAllOrderStatus();
	}

}
