package com.nfta.stopsTransaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.User;

@Component
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
