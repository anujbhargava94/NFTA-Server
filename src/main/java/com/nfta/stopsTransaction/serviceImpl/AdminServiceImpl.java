package com.nfta.stopsTransaction.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.service.EmailSenderService;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.service.AdminService;
import org.springframework.mail.SimpleMailMessage;
//import com.springsecurity.demo.service.repository.ConfirmationTokenRepository;



@Service
@Component
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public String addUser(AdminUser adminUser) {
		return adminDao.addUser(adminUser);
	}

	@Override
	public void sendMail(String email_id) {
		// Create the email
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email_id);
		mailMessage.setSubject("Complete Password Reset!");
		mailMessage.setFrom("no-reply@nfta.com");
		mailMessage.setText("To complete the password reset process, please click here: ");
		//mailMessage.setText("To complete the password reset process, please click here: "
		//  + "http://localhost:8080/confirm-reset?token="+confirmationToken.getConfirmationToken());

		// Send the email
		emailSenderService.sendEmail(mailMessage);
		
	}

	@Override
	public String findUser(AdminUser adminUser) {
		if (adminDao.findUser(adminUser))
		{
			sendMail(adminUser.getEmail_id());
		}
		
		return null;
	}

}
