package com.email.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.service.mailService;

import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.websocket.server.PathParam;

@RestController
public class mailController {
	Logger logger=LoggerFactory.getLogger(mailController.class);
	
	@Autowired
	private mailService mailService;
	
	@PostConstruct
	public String getName()
	{
		
		logger.info("My Name is Lakhan");
		logger.info("My Name is Lakhan");
		logger.info("My Name is Lakhandfds fs ff d");
		return "My Name is Lakhan";
	}
	
	@PostMapping("/")
	//@Scheduled(cron = "*/5 * * * * ?")
	public String sendMail()
	{
		this.mailService.simplemailSender("jenilpatel264@gmail.com", "Hi jenil","u passed the exam");
		
		return "success";
	}
	@PostMapping("/jenil")
	//@Scheduled(cron = "* */5 * * * *")
	public String sendMail1() throws MessagingException
	{
		this.mailService.attachSender("jenilpatel264@gmail.com", "jenil patel","u passed the exam","D:\\jenil's_Resume.pdf");
		
		return "Success Message Sent";
	}
	
	@GetMapping("/c")
	public ResponseEntity<?> getCounty()
	{
		return new ResponseEntity<>(this.mailService.getAllCountry(),HttpStatus.OK);
	}

}
