package com.lj.redwine.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.OrderItem;
import com.lj.redwine.pojo.Orders;
import com.lj.redwine.service.OrdersService;

@Controller  
@RequestMapping("/orders")  
public class OrdersController {
	@Resource
	OrdersService ordersService;
	
	@RequestMapping(value="/listOrders", method=RequestMethod.GET)
	public String findAllOrder(HttpServletRequest request, Model model) { //查找所有订单
		List<Orders> orderList = ordersService.findAllOrders();
		model.addAttribute("orderList", orderList);
		return "orders/listOrders";
	}
	
	
	
	@RequestMapping(value="/listOrderItem", method=RequestMethod.GET)
	public String findOrderItem(int id, HttpServletRequest request, Model model) { //根据订单id查询子订单
		Orders orders = ordersService.queryOrderItemByOrderId(id);
		List<OrderItem> orderItemList = orders.getOrderItemList();
		model.addAttribute("orderItemList", orderItemList);
		return "orders/listOrderItem";
	}
	
	@RequestMapping(value="/addOrders")
	@ResponseBody
	public String addOrder(HttpServletRequest request,@RequestParam Map<String, String> map) {//添加订单
		Orders orders = new Orders();
		orders.setUser_id(Integer.valueOf(map.get("user_id")));
		orders.setAddress_id(Integer.valueOf(map.get("address_id")));
		orders.setDeliver_time(map.get("deliver_time").toString());
		orders.setOrder_status_id(Integer.valueOf(map.get("order_status_id")));
		orders.setTotal_price(Float.valueOf(map.get("total_price")));
		Date date = new Date();//获取系统当前时间
		orders.setOrder_time(date);
		ordersService.addOrders(orders);
		return String.valueOf(orders.getOrder_id());
	}
	
	@RequestMapping(value="/listOrderByUserId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String listOrderByUserId(HttpServletRequest request, int user_id, int id) { //按照用户id查询订单
		List<Orders> orderList = ordersService.queryOrderByUserId(user_id, id);
		return JSON.toJSONString(orderList);
	}
	
}
