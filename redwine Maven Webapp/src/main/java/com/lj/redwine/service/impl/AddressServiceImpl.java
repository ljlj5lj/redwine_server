package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.AddressDao;
import com.lj.redwine.pojo.Address;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressDao addressDao;

	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return this.addressDao.addAddress(address);
	}

	public Address queryAddressById(int id) {
		// TODO Auto-generated method stub
		return this.addressDao.queryAddressById(id);
	}

	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
		return this.addressDao.deleteAddress(address);
	}

	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return this.addressDao.updateAddress(address);
	}

	public User queryUserByAddressId(int id) {
		// TODO Auto-generated method stub
		return this.addressDao.queryUserByAddressId(id);
	}

	public List<Address> findAllAddress() {
		// TODO Auto-generated method stub
		return this.addressDao.findAllAddress();
	}

	public List<Address> queryAddressByUserId(int id) {
		// TODO Auto-generated method stub
		return this.addressDao.queryAddressByUserId(id);
	}
	
	
}
