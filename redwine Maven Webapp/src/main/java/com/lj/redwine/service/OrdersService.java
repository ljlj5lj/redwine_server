package com.lj.redwine.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.redwine.pojo.OrderStatus;
import com.lj.redwine.pojo.Orders;
import com.lj.redwine.pojo.User;

public interface OrdersService {
	//添加订单
	public void addOrders(Orders orders);
		
	//通过id查询订单
	public Orders queryOrdersById(int id);
		
	//删除订单  
	public void deleteOrders(int id); 
	
	//撤销订单
	public boolean removeOrders(int id);
	    
	//根据订单id查询用户
	public User queryUserByOrderId(int id);
	
	//根据订单id订单状态
	public OrderStatus queryOrderStatusByOrderId(int id);
	
	//根据订单id查询子订单
	public Orders queryOrderItemByOrderId(int id);
	
	//查询所有我的收藏
	public List<Orders> findAllOrders();
	
	//根据用户id查询订单
	public List<Orders> queryOrderByUserId(@Param(value="user_id") int user_id, @Param(value="id") int id);
}
