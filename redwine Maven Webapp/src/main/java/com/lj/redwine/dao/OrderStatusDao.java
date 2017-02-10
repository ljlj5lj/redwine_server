package com.lj.redwine.dao;

import java.util.List;

import com.lj.redwine.pojo.OrderStatus;

public interface OrderStatusDao {
	//添加订单状态
	public void addOrderStatus(OrderStatus orderStatus);
		
	//通过id查询订单状态
	public OrderStatus queryOrderStatusById(int id);
		
	//删除订单状态  
	public void deleteOrderStatus(int id); 
	    
	//修改订单状态信息  
	public void updateOrderStatus(OrderStatus orderStatus);  
	
	//查询所有订单状态
	public List<OrderStatus> findAllOrderStatus();
	
	//根据订单状态id查询订单
	public OrderStatus queryOrdersByOrderStatusId(int id);
}
