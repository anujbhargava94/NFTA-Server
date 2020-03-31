package com.nfta.stopsTransaction.daoImpl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.AdminDao;
import com.nfta.stopsTransaction.model.AdminUser;
import java.util.List;
@Component
@Service
@Transactional
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public String addUser(AdminUser adminUser) {
		// TODO Auto-generated method stub
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
	public String deleteUser(int user_id) {
		// TODO Auto-generated method stub
		AdminUser adminUser=em.find(AdminUser.class,user_id );
		if(adminUser!=null)
		{
			em.remove(adminUser);
			em.flush();
			em.clear();
			return "User Successfuly deleted";
		}
		else {
			return "No user present with this ID";}
	}

	
	@Override
	public List<AdminUser> getAllUsers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM AdminUser r").getResultList();
	}

	@Override
	public List<AdminUser> getUser(int user_id) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT r FROM AdminUser "+user_id).getResultList();
	}

	@Override
	public String update(AdminUser adminUser) {
		// TODO Auto-generated method stub
		AdminUser temp=em.find(AdminUser.class, adminUser.getUser_id());
		if(temp==null)
		{return "No such user present";}
		temp.setFirst_name(adminUser.getFirst_name());
		temp.setEmail_id(adminUser.getEmail_id());
		temp.setLast_name(adminUser.getLast_name());
		temp.setPassword(adminUser.getPassword());
		return "Admin successfully updated";
	}

}
