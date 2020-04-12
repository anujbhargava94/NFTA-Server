package com.nfta.stopsTransaction.serviceImpl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionsDao transactionsDao;

	@Override
	public List<StopTransactions> getTransactions(SearchFilters searchFilters) {

		List<StopTransactions> list = transactionsDao.get(searchFilters);
		return list;
	}

	
	@Override
	public List<StopTransactions> getAllTransactions() {
		List<StopTransactions> list = transactionsDao.getAll();
		return list;
	}

	@Override
	public String addOrUpdate(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		return transactionsDao.addOrUpdate(stopTransaction);
		//String status = transactionsDao.addOrUpdate(stopTransaction);
		//if (status == ""){
		//		sendMail()
		//}
	}

	@Override
	public String updateStopsInformation(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		return transactionsDao.update(stopTransaction);
	}
	
	@Override
	public void sendMail(String email_id, StopTransactions stopTransaction) {
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
            message.setSubject("New Transaction Added");

            //message.setText("To complete the password reset process, please click here: "
            //        + "http://localhost:8080/confirmreset?token=");
            message.setText("New transaction Details: " + stopTransaction);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

}
