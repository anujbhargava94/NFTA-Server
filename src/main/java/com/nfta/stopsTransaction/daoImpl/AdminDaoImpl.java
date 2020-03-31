package com.nfta.stopsTransaction.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import com.nfta.stopsTransaction.model.ServiceRequest;

@Component
@Service
@Transactional
public class AdminDaoImpl implements AdminDao{
	
	
	@PersistenceContext
	private EntityManager em;
	


	@Override
	public String addUser(AdminUser adminUser) {
		try
		{
			em.persist(adminUser);
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
		return "";
	}

	@Override
	public boolean findUser(AdminUser adminUser) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if(cb.equal(userReq.get("email_id"), adminUser.getEmail_id()) != null)
			return true;
		return false;
	}

	@Override
	public String saveConfirmationToken(String email_id, String token) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		/** Save token in database when email id matches **/
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if(cb.equal(userReq.get("email_id"), email_id) != null) {
	        CriteriaUpdate<AdminUser> update = cb.createCriteriaUpdate(AdminUser.class);
	        Root <AdminUser> e = update.from(AdminUser.class);

	        // set update and where clause
	        update.set("reset_token", token);
	        update.where(cb.equal(e.get("email_id"), email_id));

	        // perform update
	        this.em.createQuery(update).executeUpdate();
		}
		else {
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
		if(cb.equal(userReq.get("email_id"), adminUser.getEmail_id()) != null) {
	        CriteriaUpdate<AdminUser> update = cb.createCriteriaUpdate(AdminUser.class);
	        Root <AdminUser> e = update.from(AdminUser.class);
	        update.set("password", adminUser.getPassword());
	        update.where(cb.equal(e.get("email_id"), adminUser.getEmail_id()));
	        this.em.createQuery(update).executeUpdate();
	        
	    /** Delete the token from database **/
	        update.set("reset_token", null);
	        update.where(cb.equal(e.get("email_id"), adminUser.getEmail_id()));
	        this.em.createQuery(update).executeUpdate();
		}
		else {
			return "User does not exist";
		}
		return null;
	}

	@Override
	public String confirmToken(String token) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdminUser> cq = cb.createQuery(AdminUser.class);
		Root<AdminUser> userReq = cq.from(AdminUser.class);
		if(cb.equal(userReq.get("reset_token"), token) != null) {
			return "valid token";
		}
		return "This is an invalid reset link";
	}

}

