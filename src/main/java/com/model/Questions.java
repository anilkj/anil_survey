package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "questions")
public class Questions implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	private Integer questionsId;
	private Survey survey;
	private String questionType;
	private String question;
	private String answer;
	private Calendar dateCreated;
	private Set<Questions> questions;
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "parentQuestions")
    public Set<Questions> getQuestions() {
        return questions;
    }
    public void setQuestions(Set<Questions> questions) {
        this.questions = questions;
    }
    private Questions parentQuestions;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_questions_id")
    public Questions getParentQuestions() {
        return parentQuestions;
    }
    public void setParentQuestions(Questions parentQuestions) {
        this.parentQuestions = parentQuestions;
    }
	
    public Questions() {
	}

	public Questions(Survey survey, String questionType, 
			String question, String answer,Calendar dateCreated) {
		this.survey = survey;
		this.questionType = questionType;
		this.question = question;
		this.answer = answer;
		this.dateCreated = dateCreated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "questions_id", unique = true, nullable = false)
	public Integer getQuestionsId() {
		return this.questionsId;
	}

	public void setQuestionsId(Integer questionsId) {
		this.questionsId = questionsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id", nullable = false)
	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	

	@Column(name = "question_type")
	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Column(name = "question")
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "answer")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "date_created")
	public Calendar getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}
}
