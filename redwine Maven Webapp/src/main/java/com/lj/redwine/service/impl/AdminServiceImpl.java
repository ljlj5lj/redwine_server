package com.lj.redwine.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.AdminDao;
import com.lj.redwine.pojo.Admin;
import com.lj.redwine.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;
	public Admin adminLogin(String admin_name, String admin_password) {
		// TODO Auto-generated method stub
		return this.adminDao.adminLogin(admin_name, admin_password);
	}

}
