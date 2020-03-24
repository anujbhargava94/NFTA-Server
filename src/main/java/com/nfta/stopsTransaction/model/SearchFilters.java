package com.nfta.stopsTransaction.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class SearchFilters {
	
	private String stopID;
	private String location;
	private String direction;
	private String county;
	private String dateFrom;
	private String dateTo;
	private String requestType;
	private String status;
	private Long transaction_no;
	
	
	public Long getTransaction_no() {
		return transaction_no;
	}

	public void setTransaction_no(Long transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getStopID() {
		return stopID;
	}

	public void setStopID(String stopID) {
		this.stopID = stopID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}


	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
