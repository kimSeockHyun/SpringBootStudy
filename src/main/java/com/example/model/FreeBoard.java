package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@SequenceGenerator(
		  name = "FREE_BOARD_SEQ_GENERATOR", 
		  sequenceName = "FREE_BOARD_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
		  initialValue = 1,
		  allocationSize = 1)
@Table(name = "freeBoard")
public class FreeBoard {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.SEQUENCE
				   , generator = "FREE_BOARD_SEQ_GENERATOR" )
	
	@Column(name="freeId")
	private Long freeId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="updateUserId")
	private String updateUserId;
	
	@Column(name="updatDt")
	private String updatDt;
	
	@Column(name="registUserId")
	private String registUserId;
	
	@Column(name="registDt")
	private String registDt;
	
	
	public Long getFreeId() {
		return freeId;
	}
	public void setFreeId(Long freeId) {
		this.freeId = freeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getUpdatDt() {
		return updatDt;
	}
	public void setUpdatDt(String updatDt) {
		this.updatDt = updatDt;
	}
	public String getRegistUserId() {
		return registUserId;
	}
	public void setRegistUserId(String registUserId) {
		this.registUserId = registUserId;
	}
	public String getRegistDt() {
		return registDt;
	}
	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}
	

	
}
