package com.nfta.stopsTransaction.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
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
	
	
	
	private String requested_user;
	private String location;
	@JsonInclude()
	@Transient
	private Dropdowns direction;
	@JsonInclude()
	@Transient
	private List<Dropdowns> route;
	private String reason;
	private String stop_id;
	private String additional_information;
	private String status;
	private String request_type;
	
	private String image0;
	private String image1;
	private String image2;

	@ManyToMany
	@JoinTable(name = "dropdown_serviceRequest", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "dropdown_id"))
	private List<Dropdowns> dropdowns = new ArrayList<>();
	
	
	public List<Dropdowns> getDropdowns() {
		return dropdowns;
	}

	public void setDropdowns(List<Dropdowns> dropdowns) {
		this.dropdowns = dropdowns;
	}

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
 	@CreationTimestamp
 	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private java.sql.Timestamp create_date_time;
 
//     @UpdateTimestamp
//     private LocalDateTime updateDateTime;
	
	public java.sql.Timestamp getCreate_date_time() {
		return create_date_time;
	}

	public void setCreate_date_time(java.sql.Timestamp create_date_time) {
		this.create_date_time = create_date_time;
	}

	public Integer getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
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
	public Dropdowns getDirection() {
		return direction;
	}
	public void setDirection(Dropdowns direction) {
		this.direction = direction;
	}
	public List<Dropdowns> getRoute() {
		return route;
	}
	public void setRoute(List<Dropdowns> route) {
		this.route = route;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStop_id() {
		return stop_id;
	}
	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
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
	
	


// 	public LocalDateTime getUpdateDateTime() {
// 		return updateDateTime;
// 	}

// 	public void setUpdateDateTime(LocalDateTime updateDateTime) {
// 		this.updateDateTime = updateDateTime;
// 	}
	
}
