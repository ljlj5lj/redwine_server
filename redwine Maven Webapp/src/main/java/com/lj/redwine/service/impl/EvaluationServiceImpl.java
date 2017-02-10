package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.EvaluationDao;
import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.EvaluationService;

@Service("evaluationService")
public class EvaluationServiceImpl implements EvaluationService {
	
	@Resource
	private EvaluationDao evaluationDao;

	public boolean addEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return this.evaluationDao.addEvaluation(evaluation);
	}

	public Evaluation queryEvaluationById(int id) {
		// TODO Auto-generated method stub
		return this.evaluationDao.queryEvaluationById(id);
	}

	public void deleteEvaluation(int id) {
		// TODO Auto-generated method stub
		this.evaluationDao.deleteEvaluation(id);
	}

	public User queryUserByEvaluationId(int id) {
		// TODO Auto-generated method stub
		return this.evaluationDao.queryUserByEvaluationId(id);
	}

	public Redwine queryRedWineByEvaluationId(int id) {
		// TODO Auto-generated method stub
		return this.evaluationDao.queryRedWineByEvaluationId(id);
	}

	public List<Evaluation> findAllEvaluation() {
		// TODO Auto-generated method stub
		return this.evaluationDao.findAllEvaluation();
	}

	public List<Evaluation> queryEvaluationByRedwineId(int id) {
		// TODO Auto-generated method stub
		return this.evaluationDao.queryEvaluationByRedwineId(id);
	}

	public List<Evaluation> queryEvaluationByUserId(int id) {
		// TODO Auto-generated method stub
		return this.evaluationDao.queryEvaluationByUserId(id);
	}
	
	
}
