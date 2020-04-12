package com.nfta.stopsTransaction.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.Dropdowns;

@Component
@Service
@Transactional
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public String addUser(AdminUser adminUser) {
		try {
			em.persist(adminUser);
		} catch (IllegalArgumentException e) {
			return "Illegal Argument";
		}
		return "";
	}

	@Override
	public boolean findUser(AdminUser adminUser) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if (cb.equal(userReq.get("username"), adminUser.getUsername()) != null)
			return true;
		return false;
	}

	@Override
	public String saveConfirmationToken(String username, String token) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		/** Save token in database when email id matches **/
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if (cb.equal(userReq.get("username"), username) != null) {
			CriteriaUpdate<AdminUser> update = cb.createCriteriaUpdate(AdminUser.class);
			Root<AdminUser> e = update.from(AdminUser.class);

			// set update and where clause
			update.set("reset_token", token);
			update.where(cb.equal(e.get("username"), username));

			// perform update
			this.em.createQuery(update).executeUpdate();
		} else {
			return "User does not exist";
		}

		return null;
	}

	@Override
	public String updatePassword(AdminUser adminUser) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		/** Match the email_id and save the password **/
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if (cb.equal(userReq.get("username"), adminUser.getUsername()) != null) {
			CriteriaUpdate<AdminUser> update = cb.createCriteriaUpdate(AdminUser.class);
			Root<AdminUser> e = update.from(AdminUser.class);
			update.set("password", bcryptEncoder.encode(adminUser.getPassword()));
			update.where(cb.equal(e.get("username"), adminUser.getUsername()));
			this.em.createQuery(update).executeUpdate();

			/** Delete the token from database **/
			update.set("reset_token", null);
			update.where(cb.equal(e.get("username"), adminUser.getUsername()));
			this.em.createQuery(update).executeUpdate();
		} else {
			return "User does not exist";
		}
		return null;
	}

	@Override
	public AdminUser confirmToken(String token) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if (cb.equal(userReq.get("reset_token"), token) != null) {
			 CriteriaQuery<AdminUser> q = cb.createQuery(AdminUser.class);
			 Root<AdminUser> c = q.from(AdminUser.class);
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.equal(c.get("reset_token"), token));
			q.where(predicates.toArray(new Predicate[0]));
			
			List<AdminUser> adminusers =  em.createQuery(q).getResultList();
			return adminusers.get(0);
			//return "valid token";
		}
		//return "This is an invalid reset link";
		return null;
	}

	@Override
	public String update(AdminUser adminUser) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<AdminUser> update = cb.createCriteriaUpdate(AdminUser.class);
		Root<AdminUser> e = update.from(AdminUser.class);
		update.set("first_name", adminUser.getFirst_name());
		update.set("last_name", adminUser.getLast_name());
		update.where(cb.equal(e.get("username"), adminUser.getUsername()));
		this.em.createQuery(update).executeUpdate();
		return null;
	}

	public String deleteUser(int user_id) {
		// TODO Auto-generated method stub
		AdminUser adminUser = em.find(AdminUser.class, user_id);
		if (adminUser != null) {
			em.remove(adminUser);
			em.flush();
			em.clear();
			return "User Successfuly deleted";
		} else {
			return "No user present with this ID";
		}
	}

	@Override
	public List<AdminUser> getAllUsers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM AdminUser r order by user_id").getResultList();
	}

	@Override
	public List<AdminUser> getUser(int user_id) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM AdminUser " + user_id).getResultList();
	}

//	@Override
//	@Deprecated
//	public String update(AdminUser adminUser) {
//		// TODO Auto-generated method stub
//		AdminUser temp = em.find(AdminUser.class, adminUser.getUser_id());
//		if (temp == null) {
//			return "No such user present";
//		}
//		temp.setFirst_name(adminUser.getFirst_name());
//		temp.setLast_name(adminUser.getLast_name());
//		temp.setPassword(adminUser.getPassword());
//		return "Admin successfully updated";
//	}

}
