package com.example.polls.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
//@EntityListeners(Auti)
@JsonIgnoreProperties(
		value = {"createAt", "updateAt"},
		allowGetters = true 
		
		)
public abstract class DateAudit implements Serializable{
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Instant createAt;
	
	@LastModifiedDate
	@Column(nullable = false, updatable = false)
	private Instant updateAt;

	public Instant getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Instant createAt) {
		this.createAt = createAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Instant updateAt) {
		this.updateAt = updateAt;
	}
		
}