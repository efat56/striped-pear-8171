package com.masai.login;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currentSessionId;
	private Integer customerId;
	private String uuid;
	private LocalDateTime dateTime;
	
	public CurrentUserSession(Integer customerId, String uuid, LocalDateTime dateTime) {
		super();
		this.customerId = customerId;
		this.uuid = uuid;
		this.dateTime = dateTime;
	}

	public Integer getCurrentSessionId() {
		return currentSessionId;
	}

	public void setCurrentSessionId(Integer currentSessionId) {
		this.currentSessionId = currentSessionId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	

}
