package com.lj.redwine.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer order_id;//订单id

    private Date order_time;//下单时间

    private Float total_price;//订单总价

    private OrderStatus order_status;//一个订单状态对应多个订单

    private User user;//一个用户对应多个订单
    
    private Address address;//一个地址对应多个订单
    
    private List<OrderItem> orderItemList;//一个订单对应多个子订单

    private Integer order_status_id;//订单状态id(外键)
    
    private Integer user_id;//用户id(外键)
    
    private Integer address_id;//地址id(外键)
    
    private String deliver_time;//配送方式
    
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getDeliver_time() {
		return deliver_time;
	}

	public void setDeliver_time(String deliver_time) {
		this.deliver_time = deliver_time;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Float total_price) {
		this.total_price = total_price;
	}

	public OrderStatus getOrder_status() {
		return order_status;
	}

	public void setOrder_status(OrderStatus order_status) {
		this.order_status = order_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public Integer getOrder_status_id() {
		return order_status_id;
	}

	public void setOrder_status_id(Integer order_status_id) {
		this.order_status_id = order_status_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}