package com.sanchez.carlos.messengerbq.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanchez.carlos.messengerbq.entity.User;
import com.sanchez.carlos.messengerbq.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController
{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model)
	{

		User user = new User();
		model.addAttribute("userForm", user);

		return "adduser";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postUserFrom(final @ModelAttribute("userForm") @Valid User user, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "adduser";
		}
		else if(userService.getUser(user.getId()) != null)
		{
			return "alreadyadded";
		}
		else
		{
			userService.addUser(user);
		}

		return "okuser";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model model)
	{

		List<User> list = userService.getUserList();
		model.addAttribute("userList", list);

		return "listuser";
	}

}