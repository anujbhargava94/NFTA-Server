package com.nfta.stopsTransaction.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.dao.TransactionsDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.Dropdowns;
import com.nfta.stopsTransaction.model.SearchFilters;
import com.nfta.stopsTransaction.model.StopTransactions;
import com.nfta.stopsTransaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionsDao transactionsDao;

	@Autowired
	AdminDao adminDao;

	@Override
	public List<StopTransactions> getTransactions(SearchFilters searchFilters) {

		List<StopTransactions> list = transactionsDao.get(searchFilters);
		if (list != null && !list.isEmpty()) {
			for (StopTransactions transaction : list) {
				setRespectiveDropDowns(transaction);
			}
		}
		return list;
	}

	@Override
	public List<StopTransactions> getAllTransactions() {
		List<StopTransactions> list = transactionsDao.getAll();
		if (list != null && !list.isEmpty()) {
			for (StopTransactions transaction : list) {
				setRespectiveDropDowns(transaction);
			}
			Collections.sort(list, comparator);
		}
		return list;
	}

	@Override
	public String addOrUpdate(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		// return transactionsDao.addOrUpdate(stopTransaction);
		consolidateDropDowns(stopTransaction);
		String status = transactionsDao.addOrUpdate(stopTransaction);
		if (status == "") {
			List<AdminUser> adminUsers = adminDao.getAllUsers();
			for (AdminUser adminUser : adminUsers) {
				sendMail(adminUser.getUsername(), stopTransaction);
			}
		}
		return status;
	}

	private void consolidateDropDowns(StopTransactions transaction) {
		// TODO Auto-generated method stub
		if (transaction != null 
				&& (transaction.getDropdowns() == null || transaction.getDropdowns().isEmpty())) {
			List<Dropdowns> dropDowns = new ArrayList<>();
			if (transaction.getRoutes() != null) {
				dropDowns.addAll(transaction.getRoutes());
			} if (transaction.getCounty() != null) {
				dropDowns.add(transaction.getCounty());
			} if (transaction.getFastened_to() != null) {
				dropDowns.add(transaction.getFastened_to());
			}  if (transaction.getDirection() != null) {
				dropDowns.add(transaction.getDirection());
			}  if (transaction.getPosition() != null) {
				dropDowns.add(transaction.getPosition());
			}
			transaction.setDropdowns(dropDowns);
		}

	}

	@Override
	public String updateStopsInformation(StopTransactions stopTransaction) {
		// TODO Auto-generated method stub
		consolidateDropDowns(stopTransaction);
		return transactionsDao.update(stopTransaction);
	}

	Comparator<StopTransactions> comparator = new Comparator<StopTransactions>() {
		@Override
		public int compare(StopTransactions left, StopTransactions right) {
			// return left.getTransaction_no().intValue() -
			// right.getTransaction_no().intValue();
			return right.getTransaction_no().intValue() - left.getTransaction_no().intValue();
		}
	};

	@Override
	public void sendMail(String email_id, StopTransactions stopTransaction) {
		final String username = "nftaapp@gmail.com";
		final String password = "Nfta@1234";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("no-reply@nfta.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_id));
			message.setSubject("New Transaction Added " + stopTransaction.getTransaction_no());

			ObjectMapper mapper = new ObjectMapper();
			try {
				String jsonStopTransaction = mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(stopTransaction);
				message.setText("New transaction Details: " + jsonStopTransaction);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void setRespectiveDropDowns(StopTransactions transaction) {
		if (transaction != null && transaction.getDropdowns() != null && !transaction.getDropdowns().isEmpty()) {
			List<Dropdowns> dropDowns = transaction.getDropdowns();
			List<Dropdowns> routes = new ArrayList<>();
			for (Dropdowns element : dropDowns) {
				if (element.getDropdown_type().equals("route")) {
					routes.add(element);
				}  if (element.getDropdown_type().equals("county")) {
					transaction.setCounty(element);
				}  if (element.getDropdown_type().equals("fastenedTo")) {
					transaction.setFastened_to(element);
				}  if (element.getDropdown_type().equals("direction")) {
					transaction.setDirection(element);
				}  if (element.getDropdown_type().equals("position")) {
					transaction.setPosition(element);
				}

			}
			transaction.setRoutes(routes);

		}

	}

}
