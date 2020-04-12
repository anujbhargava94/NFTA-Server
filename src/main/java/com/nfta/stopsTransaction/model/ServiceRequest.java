package com.nfta.stopsTransaction.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	@GeneratedValue(strategy = GenerationType.TABLE)
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
	
	private String image0;
	private String image1;
	private String image2;

	public String getImage0() {
		return image0;
	}

	public void setImage0(String image0) {
		this.image0 = image0;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}
// 	@CreationTimestamp
//     private LocalDateTime createDateTime;
 
//     @UpdateTimestamp
//     private LocalDateTime updateDateTime;
	
	public Integer getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}

	public Integer getAdmin_user_id() {
		return admin_user_id;
	}
	public void setAdmin_user_id(Integer admin_user_id) {
		this.admin_user_id = admin_user_id;
	}
	public String getRequested_user() {
		return requested_user;
	}
	public void setRequested_user(String requested_user) {
		this.requested_user = requested_user;
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
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getStopId() {
		return stopId;
	}
	public void setStopId(Integer stopId) {
		this.stopId = stopId;
	}
	public String getAdditional_information() {
		return additional_information;
	}
	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	
	
	
// 	public LocalDateTime getCreateDateTime() {
// 		return createDateTime;
// 	}

// 	public void setCreateDateTime(LocalDateTime createDateTime) {
// 		this.createDateTime = createDateTime;
// 	}

// 	public LocalDateTime getUpdateDateTime() {
// 		return updateDateTime;
// 	}

// 	public void setUpdateDateTime(LocalDateTime updateDateTime) {
// 		this.updateDateTime = updateDateTime;
// 	}
	
}
