package com.nfta.stopsTransaction.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "stop_transactions")
public class StopTransactions {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "transaction_no")
	private Long transaction_no;
	
	@Column(nullable = false)
	private String device_id;
	@Column(nullable = false)
	private String stop_id;
	@Column(nullable = false)
	private String direction;
	private String street_on;
	private String nearest_cross_street;
	private String position;
	private String fastened_to;
	private String latitude;
	private String longitude;
	@Column(nullable = false)
	private String county;
	@Column(nullable = false)
    	private String status;
	@Column(nullable = false)
	private Boolean shelter;
	@Column(nullable = false)
	private Boolean advertisement;
	@Column(nullable = false)
	private Boolean bench;
	@Column(nullable = false)
	private Boolean bike_rack;
	@Column(nullable = false)
	private Boolean trash_can;
	@Column(nullable = false)
	private Boolean time_table;
	@Column(nullable = false)
	private Boolean system_map;
	
	@OneToOne
	@JoinColumn(name = "request_id")
	private ServiceRequest work_request;
 
	private Blob[] photo;

}
