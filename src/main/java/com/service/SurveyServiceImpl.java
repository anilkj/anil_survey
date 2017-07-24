package com.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dao.SurveyDao;
import com.model.Questions;
import com.model.Survey;
import com.util.HibernateUtil;
import com.wrapper.SurveyWrapper;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private HibernateUtil hibernateUtil;
	
	@Override
	@Transactional
	public Survey getResult() throws Exception{
		Survey surList=null;
		try{
			surList=surveyDao.getResult();
			
		} catch(Exception e){
			
		}
		return surList;
		
	}
	
	@Override
	@Transactional
	public Integer saveSurvey(SurveyWrapper surveyWrapper) throws Exception{
		Survey survey=null;
		Integer returnCode=null;
		try{	
			if(surveyWrapper!=null){
				survey=new Survey();
				SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
				if(!StringUtils.isEmpty(surveyWrapper.getName())){
					survey.setName(surveyWrapper.getName());
				}
				
				if(!StringUtils.isEmpty(surveyWrapper.getDateOfBirth())){
					Calendar calendar = Calendar.getInstance();
					Date dateObj = curFormater.parse(surveyWrapper.getDateOfBirth()); 
					calendar.setTime(dateObj);
					survey.setDateOfBirth(calendar);
				}
				
				if(!StringUtils.isEmpty(surveyWrapper.getPhone())){
					survey.setPhone(surveyWrapper.getPhone());
				}
				
				if(!StringUtils.isEmpty(surveyWrapper.getAddress())){
					survey.setAddress(surveyWrapper.getAddress());
				}
				
				Date currentDate = new Date();
				Calendar calendarNew = Calendar.getInstance();
				calendarNew.setTime(currentDate);
				survey.setDateCreated(calendarNew);
				returnCode = (Integer) hibernateUtil.save(survey);
				
				Set<Questions> questionSet=surveyWrapper.getQuestions();
				Questions questionObect=null;
				for(Questions ques: questionSet){
					questionObect=new Questions();
					
					if(!StringUtils.isEmpty(ques.getQuestionType())){
						questionObect.setQuestionType(ques.getQuestionType());
					}
					
					if(!StringUtils.isEmpty(ques.getQuestion())){
						questionObect.setQuestion(ques.getQuestion());
					}
					
					if(!StringUtils.isEmpty(ques.getAnswer())){
						questionObect.setAnswer(ques.getAnswer());
					}
					
					questionObect.setSurvey(survey);
					
					questionObect.setDateCreated(calendarNew);
					
					hibernateUtil.save(questionObect);
				}
				
				
			}
			return returnCode;	
		} catch(Exception e){
			throw e;
		}
		
	}
	
}
