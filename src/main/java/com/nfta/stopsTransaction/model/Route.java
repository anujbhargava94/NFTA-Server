package com.nfta.stopsTransaction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Route {

	  @Id
	  //@GeneratedValue(strategy=GenerationType.AUTO)
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
