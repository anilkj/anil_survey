package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Questions;
import com.model.Survey;
import com.service.SurveyService;
import com.wrapper.SurveyWrapper;



@RestController
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	 @RequestMapping(value="/addSurvey")  
	 public ModelAndView showform(){  
	        return new ModelAndView("addSurvey");  
	 } 
	 
	 @RequestMapping(value="/saveSurvey",method = RequestMethod.POST, headers="Accept=application/json")
	 public Integer saveSurvey(@RequestBody SurveyWrapper surveyWrapper){  
		Integer returnCode=null;
		try{
			 if(surveyWrapper!=null && !StringUtils.isEmpty(surveyWrapper.getName())){
				 returnCode=surveyService.saveSurvey(surveyWrapper);
			 }
		 } catch (Exception e) {
			
		 }
		return returnCode;
	}
	
	 @RequestMapping(value="/result",method = RequestMethod.GET)   
	 public ModelAndView result(){  
		   Survey surveyList=null;
		    Map<String, Object> model=null;
		 	try{
		 		surveyList=surveyService.getResult();
		 		
		 		model=new HashMap<>();
		 		model.put("surveyList", surveyList);
		 		model.put("questionList", surveyList.getQuestions());
		 		Set<Questions> ques=surveyList.getQuestions();
		 	} catch(Exception e){
	 			
	 		}
	        return new ModelAndView("result","model",model);  
	 }
	 
	 @RequestMapping(value="/addQuestion/{qCount}",method = RequestMethod.GET)  
	 public ModelAndView addQuestion(@PathVariable("qCount") String qCount){  
	        return new ModelAndView("addQuestion","qCount",qCount);  
	 }
	 
	 @RequestMapping(value="/loadQuestionType/{qType}/{qCount}",method = RequestMethod.GET) 
	 public ModelAndView loadQuestionType(@PathVariable("qType") String qType,
			@PathVariable("qCount") String qCount){  
		 	
			 Map<String, String> model = new HashMap<>();
			 model.put("qType", qType);
			 model.put("qCount", qCount);
		 	
	        return new ModelAndView("loadQuestionType","model", model);  
	 }
	
	
}
