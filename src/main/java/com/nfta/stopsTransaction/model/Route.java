package com.nfta.stopsTransaction.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -244770141752683513L;
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "route_id")
	private Integer routeid;
	private String routeInfo;

	public Integer getRouteid() {
		return routeid;
	}

	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}

	public String getRouteInfo() {
		return routeInfo;
	}

	public void setRouteInfo(String routeInfo) {
		this.routeInfo = routeInfo;
	}
}
