package com.nfta.stopsTransaction.model;

import org.springframework.stereotype.Component;

@Component
public class SearchFiltersServiceRequest {
	
	private String requestID;
	private String stopID;
	private String direction;
	private String dateFrom;
	private String dateTo;
	private String requestType;
	private String status;
	private String adminUser;
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getStopID() {
		return stopID;
	}
	public void setStopID(String stopID) {
		this.stopID = stopID;
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
	public String getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}
	
	
}
