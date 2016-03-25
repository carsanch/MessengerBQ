package com.sanchez.carlos.messengerbq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanchez.carlos.messengerbq.entity.Message;
import com.sanchez.carlos.messengerbq.repository.MessageRespository;

@Component
public class MessageServiceImpl implements MessageService
{

	@Autowired
	MessageRespository repository;

	@Override
	public void addMessage(Message message)
	{

		repository.save(message);
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
