package com.nfta.stopsTransaction.serviceImpl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.beans.factory.annotation.Autowired;

import com.nfta.stopsTransaction.service.EmailSenderService;

@Service("emailSenderService")
public class EmailSenderServiceImpl implements EmailSenderService {
	private JavaMailSender javaMailSender;
	
	@Override
	@Autowired
	public void EmailSenderService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	@Async
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}

}
