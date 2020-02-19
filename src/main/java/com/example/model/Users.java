package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@SequenceGenerator(
		  name = "MEMBER_SEQ_GENERATOR", 
		  sequenceName = "MEMBER_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@Table(name = "users")
public class Users {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.SEQUENCE
				   , generator = "MEMBER_SEQ_GENERATOR" )
	private Long Id;
	private String userId;
	private String userPw;
	private String userNm;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	
}
