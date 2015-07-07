package com.university.thesisapp.dao.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thesis_user")
public class ThesisUser {

	protected Long thesisUserId;

	protected String name;

	@Id
	@Column(name = "thesis_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getThesisUserId() {
		return thesisUserId;
	}

	public void setThesisUserId(Long thesisUserId) {
		this.thesisUserId = thesisUserId;
	}

	@Column(name = "user_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
