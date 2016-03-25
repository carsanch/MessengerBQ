package com.sanchez.carlos.messengerbq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long internalId;

	@Column(unique = true)
	@NotEmpty
	@Length(max = 50)
	private String id;

	@Column(nullable = false)
	@NotEmpty
	private String name;

	@NotEmpty
	@Email(message = "E-mail incorrecto")
	private String email;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Long getInternalId()
	{
		return internalId;
	}

}
