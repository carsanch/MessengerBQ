package com.sanchez.carlos.messengerbq.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.carlos.messengerbq.entity.Message;

public interface MessageRespository extends CrudRepository<Message, Long>
{

	List<Message> findByUserId(String userId);

}
