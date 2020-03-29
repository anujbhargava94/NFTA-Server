package com.nfta.stopsTransaction.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {
	 public void EmailSenderService(JavaMailSender javaMailSender);
	 public void sendEmail(SimpleMailMessage email);
}
