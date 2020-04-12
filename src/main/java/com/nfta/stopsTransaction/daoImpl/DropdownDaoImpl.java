package com.nfta.stopsTransaction.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.DropdownDao;
import com.nfta.stopsTransaction.model.Dropdowns;

@Service
@Transactional
public class DropdownDaoImpl implements DropdownDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Dropdowns> getDropdown(String dropdown_type) {		
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Dropdowns> q = cb.createQuery(Dropdowns.class);
		 Root<Dropdowns> c = q.from(Dropdowns.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(c.get("dropdown_type"), dropdown_type));
		predicates.add(cb.equal(c.get("active"), 1));
		q.where(predicates.toArray(new Predicate[0]));
		
		return em.createQuery(q).getResultList();
	}

	@Override
	public String save(Dropdowns dropdown) {
		try
		{
			em.persist(dropdown);
		}
		catch(IllegalArgumentException e)
		{
			return "Illegal Argument";
		}
		return "";
	}

	@Override
	public void update(Dropdowns dropdown) {
		// TODO Auto-generated method stub

	}

	@Override
	public String delete(Dropdowns dropdown) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Dropdowns> update = cb.createCriteriaUpdate(Dropdowns.class);
		Root<Dropdowns> e = update.from(Dropdowns.class);
		/** set update and where clause **/
		update.set("active", false);
		update.where(cb.equal(e.get("dropdown_id"), dropdown.getDropdown_id()));
		/** perform update **/
		this.em.createQuery(update).executeUpdate();
		
		return "Dropdown deleted successfully";
	}

}
