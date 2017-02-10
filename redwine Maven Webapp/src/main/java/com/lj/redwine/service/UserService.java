package com.lj.redwine.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.redwine.pojo.Address;
import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.pojo.Orders;
import com.lj.redwine.pojo.User;

public interface UserService {
	//添加用户
	public boolean addUser(User user);
	
	//通过id查询用户
	public User queryUserById(int id);
	
	//删除用户  
    public void deleteUser(int id); 
    
    //修改用户信息  
    public void updateUser(User user);  
    
    //根据用户id查询地址
    public List<Address> queryAddressByUserId(int id);
    
    //根据用户id查询我的收藏
    public List<Favorites> queryCollectionByUserId(int id);
    
    //根据用户id查询我的酒评
    public List<Evaluation> queryEvaluationByUserId(int id);
    
    //根据用户id查询订单
    public List<Orders> queryOrdersByUserId(int id);
    
    //查询所有用户
    public List<User> findAllUser();
    
    //查询手机号码是否存在
    public User findTelephone(String telephone);
    
    //根据手机号码查询user
    public User findUserByTelephone(String telephone);
    
    //更新用户头像
    public void updateUserAvatarById(User user);
    
    //查询用户名是否存在
    public User findUsername(String username);
    
    //根据账号查询user
    public User findUserByAccount(@Param(value="username") String username,@Param(value="password") String password);
    
    //更新用户名
    public boolean updateUsername(@Param(value="username") String username,@Param(value="id") int id);
}
