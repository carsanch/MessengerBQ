package com.sanchez.carlos.messengerbq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanchez.carlos.messengerbq.controller.requestparam.UserFilterForm;
import com.sanchez.carlos.messengerbq.entity.Message;
import com.sanchez.carlos.messengerbq.entity.User;
import com.sanchez.carlos.messengerbq.service.MessageService;
import com.sanchez.carlos.messengerbq.service.UserService;

@Controller
@RequestMapping(value = "/message")
public class MessageController
{

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	UserService userService;

	@Autowired
	MessageService messageService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model model, @RequestParam(required = false) String select)
	{
		User user = null;
		List<User> users = userService.getUserList();

		List<Message> messages = null;

		if(select != null && !select.isEmpty())
		{
			user = userService.getUser(select);
		}

		if(user != null)
		{
			messages = messageService.getMessageByUser(user.getId());
		}
		else
		{
			messages = messageService.getMessageList();
		}

		model.addAttribute("userList", users);
		model.addAttribute("messageList", messages);

		model.addAttribute("myform", new UserFilterForm());

		return "messages";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String listUsersFilter(@RequestParam String id)
	{

		return "redirect:/message/list?select=" + id;

	}
}