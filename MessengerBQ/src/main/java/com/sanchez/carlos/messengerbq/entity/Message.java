package com.sanchez.carlos.messengerbq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long internalId;

	@Column(nullable = false)
	private String userId;

	@Column
	private String body;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public Long getInternalId()
	{
		return internalId;
	}

}
