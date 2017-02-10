package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.lj.redwine.dao.RedwineTypeDao;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.RedwineType;
import com.lj.redwine.service.RedwineTypeService;

@Service("redwineTypeService")
public class RedwineTypeServiceImpl implements RedwineTypeService {
	
	@Resource
	private RedwineTypeDao redwineTypeDao;
	
	public void addRedwineType(RedwineType redwineType) {
		// TODO Auto-generated method stub
		this.redwineTypeDao.addRedwineType(redwineType);
	}

	public RedwineType queryRedwineTypeById(int id) {
		// TODO Auto-generated method stub
		return this.redwineTypeDao.queryRedwineTypeById(id);
	}

	public boolean deleteRedwineType(int id) {
		// TODO Auto-generated method stub
		return this.redwineTypeDao.deleteRedwineType(id);
	}

	public void updateRedwineType(RedwineType redwineType) {
		// TODO Auto-generated method stub
		this.redwineTypeDao.updateRedwineType(redwineType);
	}

	public List<Redwine> queryRedWineTypeByRedWineId(int id) {
		// TODO Auto-generated method stub
		return this.redwineTypeDao.queryRedWineTypeByRedWineId(id);
	}

	public List<RedwineType> findAllRedWineType() {
		// TODO Auto-generated method stub
		return this.redwineTypeDao.findAllRedWineType();
	}
}
