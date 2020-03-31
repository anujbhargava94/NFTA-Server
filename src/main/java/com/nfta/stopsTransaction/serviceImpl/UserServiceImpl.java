package com.nfta.stopsTransaction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.RoleRepository;
import com.nfta.stopsTransaction.dao.UserRepository;
import com.nfta.stopsTransaction.model.User;
import com.nfta.stopsTransaction.service.UserService;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        User savedUser = userRepository.save(user);
        if(savedUser !=null && savedUser.getUsername()!=null) 
        {
        	System.out.println("User saved"+savedUser.getUsername());
        }else {
        	System.out.println("User not saved");
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
