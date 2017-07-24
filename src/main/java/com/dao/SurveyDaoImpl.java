package com.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Survey;


@Repository
public class SurveyDaoImpl implements SurveyDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Survey getResult() throws Exception{
		Survey surList=null;
		try{
			String hql = "FROM Survey order by surveyId Desc";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult(0);  
			query.setMaxResults(1);  
			surList = (Survey)query.uniqueResult();
		} catch(Exception e){
			
		}
		return surList;
	}
}
