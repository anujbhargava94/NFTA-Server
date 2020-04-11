package com.nfta.stopsTransaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfta.stopsTransaction.model.AdminUser;


@Repository
public interface UserDao extends CrudRepository<AdminUser, Integer> {
	AdminUser findByUsername(String username);
}
