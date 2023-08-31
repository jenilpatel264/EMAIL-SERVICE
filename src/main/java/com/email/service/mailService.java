package com.email.service;

import java.io.File;
import java.net.http.HttpHeaders;
import java.nio.file.FileSystem;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.mail.Header;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class mailService {
	
	@Autowired JavaMailSender javaMailSender;
	
	@Autowired RestTemplate restTemplate;
	
	public final static String url="https://covid-193.p.rapidapi.com/statistics";
	public final static String XRapidAPIKey="1a50e8da05msh37ee4cebf7262d8p11bc2djsn68a36cce3556";
	public final static String XRapidAPIHost="covid-193.p.rapidapi.com";
	public void simplemailSender(String to,String subject,String body)
	{
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		javaMailSender.send(mailMessage);
		System.out.println("mail send");
	}
	
	
	public void attachSender(String to,String subject,String body,String attachment) throws MessagingException
	{
		
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true);
		
		
		messageHelper.setTo(to);
		messageHelper.setText(body);
		messageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource=new FileSystemResource(new File(attachment));
		messageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
		
		javaMailSender.send(mimeMessage);
		System.out.println("mail send");
	}
	
	public Object getAllCountry()
	{
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.set("X-RapidAPI-Host", XRapidAPIHost);
		headers.set("X-RapidAPI-Key", XRapidAPIKey);
		
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers), String.class);
		
		return response.getBody();
	}

}
