package com.nfta.stopsTransaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nfta.stopsTransaction.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
