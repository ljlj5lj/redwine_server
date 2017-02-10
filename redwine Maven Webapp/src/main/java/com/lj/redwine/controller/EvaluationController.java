package com.lj.redwine.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lj.redwine.pojo.Evaluation;
import com.lj.redwine.service.EvaluationService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	@Resource
	EvaluationService evaluationService;
	
	@RequestMapping(value="/listEvaluation", method=RequestMethod.GET)
	public String findAllEvaluation(HttpServletRequest request, Model model) {//显示所有用户评价
		List<Evaluation> evaluationList = evaluationService.findAllEvaluation();
		model.addAttribute("evaluationList", evaluationList);
		return "evaluation/listEvaluation";
	}
	
	@RequestMapping("/showEvaluation")
	public String findRedwine(int id, HttpServletRequest request, Model model) { //查看评价信息
		model.addAttribute("evaluation", evaluationService.queryEvaluationById(id));
		return "evaluation/showEvaluation";
	}
	
	@RequestMapping(value="/listEvaluationByRedwineId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findEvaluationByRedwineId(HttpServletRequest request,int id) {//通过红酒id查询评价
		List<Evaluation> evaluationList = evaluationService.queryEvaluationByRedwineId(id);
		return JSON.toJSONString(evaluationList);
	}
	
	@RequestMapping(value="/listEvaluationByUserId",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String findEvaluationByUserId(HttpServletRequest request,int id) {//通过用户id查询评价
		List<Evaluation> evaluationList = evaluationService.queryEvaluationByUserId(id);
		return JSON.toJSONString(evaluationList);
	}
	
	@RequestMapping(value="/addEvaluation")
	@ResponseBody
	public String addEvaluation(HttpServletRequest request, @RequestParam Map<String, String> map) {//添加评价
		Evaluation evaluation = new Evaluation();
		evaluation.setContent(map.get("content"));
		evaluation.setGrade(Float.valueOf(map.get("grade")));
		evaluation.setUser_id(Integer.valueOf(map.get("user_id")));
		evaluation.setRedwine_id(Integer.valueOf(map.get("redwine_id")));
		Date date = new Date();
		evaluation.setEvaluation_date(date);
		if (evaluationService.addEvaluation(evaluation)) {
			return "success";
		} else {
			return "fail";
		}
	}
}
