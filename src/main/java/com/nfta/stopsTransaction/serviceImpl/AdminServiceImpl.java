package com.nfta.stopsTransaction.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.service.AdminService;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.UUID;

import javax.mail.*;



@Service
@Component
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public String addUser(AdminUser adminUser) {
		return adminDao.addUser(adminUser);
	}
	
	@Override
	public void sendMail(String email_id) {
		final String username = "nftaapp@gmail.com";
        final String password = "Nfta@1234";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
            
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@nfta.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email_id)
            );
            message.setSubject("Complete Password Reset!");
            String token = getConfirmationToken();
            message.setText("To complete the password reset process, please click here: "
                    + "http://localhost:8080/confirm-reset?token="+token);
            saveConfirmationToken(email_id, token);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

	@Override
	public String findUser(AdminUser adminUser) {
		if (adminDao.findUser(adminUser))
		{
			sendMail(adminUser.getEmail_id());
		}
		else
			return "no such user exists";
		
		return "";
	}

	@Override
	public String getConfirmationToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}

	@Override
	public String updatePassword(AdminUser adminUser) {
		return adminDao.updatePassword(adminUser);
	}

	@Override
	public String saveConfirmationToken(String email_id, String token) {
		adminDao.saveConfirmationToken(email_id,token);
		return null;
	}

	@Override
	public String confirmToken(String token) {
		return adminDao.confirmToken(token);
	}

	@Override
	public String updateUserInfo(AdminUser adminUser) {
		return adminDao.updateUserInfo(adminUser);
	}

}
