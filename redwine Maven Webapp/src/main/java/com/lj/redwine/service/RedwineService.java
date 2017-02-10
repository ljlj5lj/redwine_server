package com.lj.redwine.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.pojo.OrderItem;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.RedwineType;

public interface RedwineService {
	//添加红酒
	public void addRedWine(Redwine redwine);
		
	//通过id查询红酒
	public Redwine queryRedWineById(int id);
	
	public Redwine searchRedWineById(int id);
		
	//删除红酒  
	public boolean deleteRedWine(int id); 
	    
	//修改红酒信息  
	public void updateRedWine(Redwine redwine);  
	
	//根据红酒id查询我的收藏
	public List<Favorites> queryCollectionByRedWineId(int id);
	
	//根据红酒id查询我的酒评
	public List<Evaluation> queryEvaluationByRedWineId(int id);
	
	//根据红酒id查询子菜单 
	public List<OrderItem> queryOrderItemByRedWineId(int id);
	
	//根据红酒id查询红酒类型 
	public RedwineType queryRedWineTypeByRedWineId(int id);
	
	//查询所有红酒信息
	public List<Redwine> findAllRedWine();
	
	//按照上架日期查询红酒
	public List<Redwine> queryRedwineOrderByTime(int id);
	
	//模糊查询红酒
	public List<Redwine> searchRedwineOrderById(@Param(value="id") int id, @Param(value="name") String name);
	
	//按照销量查询红酒
	public List<Redwine> queryRedwineOrderBySales(int id);
	
	//根据红酒类型查询红酒
	public List<Redwine> queryRedWineByType(@Param(value="id") int id, @Param(value="redwine_type_id") int redwine_type_id);
}
