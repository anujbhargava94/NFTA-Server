package com.nfta.stopsTransaction.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "route_listed")
public class RouteListed implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3558177490510690235L;

	@Id
	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "transaction_no")
	private StopTransactions stopTransactions;

	public StopTransactions getStopTransactions() {
		return stopTransactions;
	}

	public void setStopTransactions(StopTransactions stopTransactions) {
		this.stopTransactions = stopTransactions;
	}

}
