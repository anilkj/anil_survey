package com.service;

import java.util.List;

import com.model.Survey;
import com.wrapper.SurveyWrapper;

public interface SurveyService {

	Integer saveSurvey(SurveyWrapper surveyWrapper) throws Exception;

	Survey getResult() throws Exception; 
 
}
