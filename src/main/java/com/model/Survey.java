package com.model;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	private Integer surveyId;
	private String name;
	private Calendar dateOfBirth;
	private String phone;
	private String address;
	private Calendar dateCreated;
	private Set<Questions> questions = new HashSet<Questions>(0);

	public Survey() {
	}

	public Survey(String name, Calendar dateOfBirth, 
			String phone, String address, Calendar dateCreated, Set<Questions> questions) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.address = address;
		this.dateCreated = dateCreated;
		this.questions=questions;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "survey_id", unique = true, nullable = false)
	public Integer getSurveyId() {
		return this.surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "date_of_birth")
	public Calendar getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "date_created")
	public Calendar getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "survey")
	public Set<Questions> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((surveyId == null) ? 0 : surveyId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (surveyId == null) {
			if (other.surveyId != null)
				return false;
		} else if (!surveyId.equals(other.surveyId))
			return false;
		return true;
	}

	
}