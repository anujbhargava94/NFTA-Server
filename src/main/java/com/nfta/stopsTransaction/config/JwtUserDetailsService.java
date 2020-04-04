package com.nfta.stopsTransaction.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.UserDao;
import com.nfta.stopsTransaction.model.UserDB;
import com.nfta.stopsTransaction.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDB user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserDB save(UserDTO user) {
		UserDB newUser = new UserDB();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		if(user.getContactInfo()!=null) {
			newUser.setContactInfo(user.getContactInfo());
		}
		if(user.getEmail()!=null) {
			newUser.setEmail(user.getEmail());
		}
		if(user.getFirstName()!=null) {
			newUser.setFirstName((user.getFirstName()));
		}
		if(user.getLastName()!=null) {
			newUser.setLastName(user.getLastName());
		}
		return userDao.save(newUser);
	}

}
