package com.lj.redwine.service;

import java.util.List;

import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.RedwineType;

public interface RedwineTypeService {
	//添加红酒类型
	public void addRedwineType(RedwineType redwineType);
		
	//通过id查询红酒类型
	public RedwineType queryRedwineTypeById(int id);
		
	//删除红酒类型  
	public boolean deleteRedwineType(int id); 
	    
	//修改红酒类型信息  
	public void updateRedwineType(RedwineType redwineType);  
	
	//根据红酒类型id查询红酒
	public List<Redwine> queryRedWineTypeByRedWineId(int id);
	
	//查询所有红酒类型
	public List<RedwineType> findAllRedWineType();
}
