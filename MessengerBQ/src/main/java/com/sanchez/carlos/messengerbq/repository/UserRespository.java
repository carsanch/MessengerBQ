package com.sanchez.carlos.messengerbq.repository;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.carlos.messengerbq.entity.User;

public interface UserRespository extends CrudRepository<User, Long>
{

	User findById(String id);

}
