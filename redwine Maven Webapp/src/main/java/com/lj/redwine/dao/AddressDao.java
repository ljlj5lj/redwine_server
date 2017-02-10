package com.lj.redwine.dao;

import java.util.List;

import com.lj.redwine.pojo.Address;
import com.lj.redwine.pojo.User;

public interface AddressDao {
	//添加地址
	public boolean addAddress(Address address);
		
	//通过id查询地址
	public Address queryAddressById(int id);
		
	//删除地址  
	public boolean deleteAddress(Address address); 
	    
	//修改地址信息  
	public boolean updateAddress(Address address);  
	
	//根据地址id查询用户
	public User queryUserByAddressId(int id);
	
	//查询所有用户地址
	public List<Address> findAllAddress();
	
	//根据用户id查询地址
	public List<Address> queryAddressByUserId(int id);
}
