package com.sanchez.carlos.messengerbq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.sanchez.carlos.messengerbq.entity.User;
import com.sanchez.carlos.messengerbq.repository.UserRespository;

@Component
public class UserServiceImpl implements UserService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Value("${mail.enable}")
	private Boolean isEnableSendMail;

	@Value("${mail.from}")
	private String FROM;

	@Value("${mail.subject}")
	private String SUBJECT;

	@Value("${mail.body}")
	private String BODY;

	@Autowired
	private UserRespository repository;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void addUser(User user)
	{
		try
		{
			repository.save(user);
		}
		catch(Exception ex)
		{
			LOGGER.error(ex.getMessage());
		}

		if(isEnableSendMail)
		{
			sendMail(user);
		}
	}

	@Override
	public User getUser(String id)
	{
		return repository.findById(id);
	}

	@Override
	public List<User> getUserList()
	{
		return (List<User>) repository.findAll();
	}

	private void sendMail(User user)
	{
		SimpleMailMessage email = new SimpleMailMessage();

		email.setFrom(FROM);
		email.setTo(user.getEmail());
		email.setSubject(SUBJECT);
		email.setText(BODY.concat(user.getId()));

		mailSender.send(email);
		LOGGER.debug("Sent mail to:" + user.getEmail());
	}

}
