package com.lj.redwine.service;

import java.util.List;

import com.lj.redwine.pojo.OrderItem;
import com.lj.redwine.pojo.Orders;

public interface OrderItemService {
	//添加子订单
	public void addOrderItem(OrderItem orderItem);
		
	//根据子订单id查询红酒
	public OrderItem queryRedWineByOrderItemId(int id);
	
	//根据子订单id查询订单
	public Orders queryOrdersByOrderItemId(int id);
	
	//根据订单id查询子订单
	public List<OrderItem> queryOrderItemByOrderId(int id);
}
