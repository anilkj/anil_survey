package com.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.util.HibernateUtil;


@Repository
public class QuestionsDaoImpl implements QuestionsDao {
	@Autowired
	private HibernateUtil hibernateUtil;
}
