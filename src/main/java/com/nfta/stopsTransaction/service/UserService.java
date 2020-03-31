package com.nfta.stopsTransaction.service;

import com.nfta.stopsTransaction.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}