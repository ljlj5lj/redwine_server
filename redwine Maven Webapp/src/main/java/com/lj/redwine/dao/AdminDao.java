package com.lj.redwine.dao;

import org.apache.ibatis.annotations.Param;

import com.lj.redwine.pojo.Admin;

public interface AdminDao {
	//管理员登录
	public Admin adminLogin(@Param(value="admin_name") String admin_name,@Param(value="admin_password") String admin_password);
}
