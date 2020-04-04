package com.nfta.stopsTransaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfta.stopsTransaction.model.UserDB;


@Repository
public interface UserDao extends CrudRepository<UserDB, Integer> {
	UserDB findByUsername(String username);
}
