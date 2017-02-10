package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.RedwineDao;
import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.pojo.OrderItem;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.RedwineType;
import com.lj.redwine.service.RedwineService;

@Service("redwineService")
public class RedwineServiceImpl implements RedwineService {
	
	@Resource
	private RedwineDao redwineDao;
	
	public void addRedWine(Redwine redwine) {
		// TODO Auto-generated method stub
		this.redwineDao.addRedWine(redwine);
	}

	public Redwine queryRedWineById(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryRedWineById(id);
	}

	public boolean deleteRedWine(int id) {
		// TODO Auto-generated method stub
		return redwineDao.deleteRedWine(id);
	}

	public void updateRedWine(Redwine redwine) {
		// TODO Auto-generated method stub
		this.redwineDao.updateRedWine(redwine);
	}

	public List<Favorites> queryCollectionByRedWineId(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryCollectionByRedWineId(id);
	}

	public List<Evaluation> queryEvaluationByRedWineId(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryEvaluationByRedWineId(id);
	}

	public List<OrderItem> queryOrderItemByRedWineId(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryOrderItemByRedWineId(id);
	}

	public RedwineType queryRedWineTypeByRedWineId(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryRedWineTypeByRedWineId(id);
	}

	public List<Redwine> findAllRedWine() {
		// TODO Auto-generated method stub
		return this.redwineDao.findAllRedWine();
	}

	public Redwine searchRedWineById(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.searchRedWineById(id);
	}

	public List<Redwine> queryRedwineOrderByTime(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryRedwineOrderByTime(id);
	}

	public List<Redwine> searchRedwineOrderById(int id, String name) {
		// TODO Auto-generated method stub
		return this.redwineDao.searchRedwineOrderById(id, name);
	}

	public List<Redwine> queryRedwineOrderBySales(int id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryRedwineOrderBySales(id);
	}

	public List<Redwine> queryRedWineByType(int id, int redwine_type_id) {
		// TODO Auto-generated method stub
		return this.redwineDao.queryRedWineByType(id, redwine_type_id);
	}

}
