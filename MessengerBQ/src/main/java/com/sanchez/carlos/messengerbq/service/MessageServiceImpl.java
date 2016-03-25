package com.sanchez.carlos.messengerbq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanchez.carlos.messengerbq.entity.Message;
import com.sanchez.carlos.messengerbq.repository.MessageRespository;

@Component
public class MessageServiceImpl implements MessageService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Autowired
	MessageRespository repository;

	@Override
	public void addMessage(Message message)
	{
		try
		{
			repository.save(message);
		}
		catch(Exception ex)
		{
			LOGGER.error(ex.getMessage());
		}
	}

	@Override
	public List<Message> getMessageList()
	{
		return (List<Message>) repository.findAll();
	}

	@Override
	public List<Message> getMessageByUser(String userId)
	{
		return repository.findByUserId(userId);
	}
}
