package com.lj.redwine.dao;

import java.util.List;

import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.User;


public interface EvaluationDao {
	//添加评价
	public boolean addEvaluation(Evaluation evaluation);
		
	//通过id查询评价
	public Evaluation queryEvaluationById(int id);
		
	//删除评价  
	public void deleteEvaluation(int id); 
	    
	//根据评价id查询用户
	public User queryUserByEvaluationId(int id);
	
	//根据评价id查询红酒
	public Redwine queryRedWineByEvaluationId(int id);
	
	//查询所有我的收藏
	public List<Evaluation> findAllEvaluation();
	
	//根据红酒id查询评论
	public List<Evaluation> queryEvaluationByRedwineId(int id);
	
	//根据用户id查询评论
	public List<Evaluation> queryEvaluationByUserId(int id);
}
