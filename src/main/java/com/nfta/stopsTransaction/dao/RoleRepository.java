package com.nfta.stopsTransaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nfta.stopsTransaction.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
