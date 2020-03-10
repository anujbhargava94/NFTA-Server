package com.nfta.stopsTransaction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import antlr.collections.List;
import lombok.Data;

@Entity
@Table(name = "service_requests")
@Data
public class ServiceRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5135881928483223568L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer request_id;
	private Integer admin_user_id;
	private String requested_user;
	private String location;
	private String direction;
	private String route;
	private String reason;
	private Integer stopId;
	private String additional_information;
	private String status;
	private String request_type;

}
