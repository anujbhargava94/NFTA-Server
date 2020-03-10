package com.nfta.stopsTransaction.model;

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
public class ServiceRequest {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer requestid;
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



