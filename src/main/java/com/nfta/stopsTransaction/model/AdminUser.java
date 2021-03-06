package com.nfta.stopsTransaction.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(unique = true)
	private String username;
	@Column
	private String password;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String contact_info;
	@Column
	private String reset_token;

	/**
	 * This is use to set date and time in SQL database // *
	 **/

 	/*@CreationTimestamp
 	@JsonIgnoreProperties("createDateTime")
 	private LocalDateTime createDateTime;

 	@UpdateTimestamp
 	@JsonIgnoreProperties("updateDateTime")
 	private LocalDateTime updateDateTime;
*/
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReset_token() {
		return reset_token;
	}

	public void setReset_token(String reset_token) {
		this.reset_token = reset_token;
	}

 	/*public LocalDateTime getCreateDateTime() {
 		return createDateTime;
 	}

 	public void setCreateDateTime(LocalDateTime createDateTime) {
 		this.createDateTime = createDateTime;
 	}

 	public LocalDateTime getUpdateDateTime() {
 		return updateDateTime;
 	}

 	public void setUpdateDateTime(LocalDateTime updateDateTime) {
 		this.updateDateTime = updateDateTime;
 	}*/

}
