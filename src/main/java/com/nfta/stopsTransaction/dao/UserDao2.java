package com.nfta.stopsTransaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfta.stopsTransaction.model.DAOUser;


@Repository
public interface UserDao2 extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
}
