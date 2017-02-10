package com.lj.redwine.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.OrderItem;
import com.lj.redwine.service.OrderItemService;

@Controller  
@RequestMapping("/orderItem")  
public class OrderItemController {
	@Resource  
	private OrderItemService orderItemService;
	
	@RequestMapping("/addOrderItem")
	@ResponseBody
	public String addUser(HttpServletRequest request, @RequestBody Map<String, String> map) {//注册用户
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder_id(Integer.valueOf(map.get("order_id")));
		orderItem.setQuantity(Integer.valueOf(map.get("quantity")));
		orderItem.setRedwine_id(Integer.valueOf(map.get("redwine_id")));
		orderItemService.addOrderItem(orderItem);
		return JSON.toJSONString(orderItem);
	}
	
	@RequestMapping(value="/listOrderItemsByOrderId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String listOrderItemsByOrderId(HttpServletRequest request,int id) {
		List<OrderItem> orderItemList = orderItemService.queryOrderItemByOrderId(id);
		return JSON.toJSONString(orderItemList);
	}
}
