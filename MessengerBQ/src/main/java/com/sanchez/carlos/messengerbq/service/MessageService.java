package com.sanchez.carlos.messengerbq.service;

import java.util.List;

import com.sanchez.carlos.messengerbq.entity.Message;

public interface MessageService
{

	void addMessage(Message message);

	List<Message> getMessageList();

	List<Message> getMessageByUser(String userId);

}
