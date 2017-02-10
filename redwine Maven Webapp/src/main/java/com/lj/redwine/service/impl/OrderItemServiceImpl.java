package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.OrderItemDao;
import com.lj.redwine.pojo.OrderItem;
import com.lj.redwine.pojo.Orders;
import com.lj.redwine.service.OrderItemService;

@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {
	@Resource
	private OrderItemDao orderItemDao;
	public void addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		this.orderItemDao.addOrderItem(orderItem);
	}

	public OrderItem queryRedWineByOrderItemId(int id) {
		// TODO Auto-generated method stub
		return this.orderItemDao.queryRedWineByOrderItemId(id);
	}

	public Orders queryOrdersByOrderItemId(int id) {
		// TODO Auto-generated method stub
		return this.orderItemDao.queryOrdersByOrderItemId(id);
	}

	public List<OrderItem> queryOrderItemByOrderId(int id) {
		// TODO Auto-generated method stub
		return this.orderItemDao.queryOrderItemByOrderId(id);
	}

}
