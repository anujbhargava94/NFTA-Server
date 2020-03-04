package com.nfta.stopsTransaction.model;

import org.springframework.stereotype.Component;

@Component
public class SearchFilters {
	
	private String stopID;
	private String location;
	private String direction;
	private String county;
	private String dateFrom;
	private String dateTo;
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
	public String getCountry() {
		return county;
	}
	public void setCountry(String country) {
		this.county = country;
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
}
