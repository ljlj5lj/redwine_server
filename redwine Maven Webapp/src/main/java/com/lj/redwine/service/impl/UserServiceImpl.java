package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.UserDao;
import com.lj.redwine.pojo.Address;
import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.pojo.Orders;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.addUser(user);
	}

	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		return this.userDao.queryUserById(id);
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		this.userDao.deleteUser(id);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateUser(user);
	}

	public List<Address> queryAddressByUserId(int id) {
		// TODO Auto-generated method stub
		return this.userDao.queryAddressByUserId(id);
	}

	public List<Favorites> queryCollectionByUserId(int id) {
		// TODO Auto-generated method stub
		return this.userDao.queryCollectionByUserId(id);
	}

	public List<Evaluation> queryEvaluationByUserId(int id) {
		// TODO Auto-generated method stub
		return this.userDao.queryEvaluationByUserId(id);
	}

	public List<Orders> queryOrdersByUserId(int id) {
		// TODO Auto-generated method stub
		return this.userDao.queryOrdersByUserId(id);
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.findAllUser();
	}

	public User findTelephone(String telephone) {
		// TODO Auto-generated method stub
		return this.userDao.findTelephone(telephone);
	}

	public User findUserByTelephone(String telephone) {
		// TODO Auto-generated method stub
		return this.userDao.findUserByTelephone(telephone);
	}

	public void updateUserAvatarById(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateUserAvatarById(user);
	}

	public User findUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.findUsername(username);
	}

	public User findUserByAccount(String username, String password) {
		// TODO Auto-generated method stub
		return this.userDao.findUserByAccount(username, password);
	}

	public boolean updateUsername(String username, int id) {
		// TODO Auto-generated method stub
		return this.userDao.updateUsername(username, id);
	}


	
}
