package com.nfta.stopsTransaction.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Table(name = "stop_transactions")
@Data
public class StopTransactions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8600502014954931750L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "transaction_no")
	private Long transaction_no;

	@Column
	private String device_id;
	private String stop_id;

	@JsonInclude()
	@Transient
	private Dropdowns direction;
	private String street_on;
	private String nearest_cross_street;
	@JsonInclude()
	@Transient
	private Dropdowns position;
	@JsonInclude()
	@Transient
	private Dropdowns fastened_to;
	private Double latitude;
	private Double longitude;
	private String location;
	@JsonInclude()
	@Transient
	private Dropdowns county;
	private String status;
	private Boolean shelter;
	private Boolean advertisement;
	private Boolean bench;
	private Boolean bike_rack;
	private Boolean trash_can;
	private Boolean time_table;
	private Boolean system_map;
	private String transaction_type;
	@JsonInclude()
	@Transient
	private List<Dropdowns> routes;

	//@ManyToMany
	//@JoinTable(name = "route_transaction", joinColumns = @JoinColumn(name = "transaction_no"), inverseJoinColumns = @JoinColumn(name = "route_id"))
	
	@ManyToMany
	@JoinTable(name = "dropdown_transaction", joinColumns = @JoinColumn(name = "transaction_no"), inverseJoinColumns = @JoinColumn(name = "dropdown_id"))
	private List<Dropdowns> dropdowns = new ArrayList<>();
	//private List<Route> routes = new ArrayList<>();

//	@Lob
//	@Column(name = "image", length = 1000)
//	private Byte[] image;

	public List<Dropdowns> getDropdowns() {
		return dropdowns;
	}

	public void setDropdowns(List<Dropdowns> dropdowns) {
		this.dropdowns = dropdowns;
	}

	/**
	 * Unidirectional Foreign keys For ServiceRequest and adminuser
	 */
	@OneToOne
	@JoinColumn(name = "request_id")
	private ServiceRequest work_request;
	
	@Column
	private String username;

	@Column
	private String admin_comments;
	@Column
	private String additional_information;
	
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

	/**
	 * This is use to set date and time in SQL database
	 **/
//	@Temporal(value=TemporalType.DATE)
//	Date date;

 	@CreationTimestamp
 	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
 	private java.sql.Timestamp create_date_time;

// 	@UpdateTimestamp
// 	@JsonIgnoreProperties("createDateTime")
// 	private LocalDateTime updateDateTime;

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getCreateDateTime() {
 		return create_date_time.toString();
 	}

 	public void setCreateDateTime(java.sql.Timestamp create_date_time) {
 		this.create_date_time = create_date_time;
 	}

// 	public LocalDateTime getUpdateDateTime() {
// 		return updateDateTime;
// 	}

// 	public void setUpdateDateTime(LocalDateTime updateDateTime) {
// 		this.updateDateTime = updateDateTime;
// 	}

	public Long getTransaction_no() {
		return transaction_no;
	}

	public void setTransaction_no(Long transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getStop_id() {
		return stop_id;
	}

	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}

	public Dropdowns getDirection() {
		return direction;
	}

	public void setDirection(Dropdowns direction) {
		this.direction = direction;
	}

	public String getStreet_on() {
		return street_on;
	}

	public void setStreet_on(String street_on) {
		this.street_on = street_on;
	}

	public String getNearest_cross_street() {
		return nearest_cross_street;
	}

	public void setNearest_cross_street(String nearest_cross_street) {
		this.nearest_cross_street = nearest_cross_street;
	}

	public Dropdowns getPosition() {
		return position;
	}

	public void setPosition(Dropdowns position) {
		this.position = position;
	}

	public Dropdowns getFastened_to() {
		return fastened_to;
	}

	public void setFastened_to(Dropdowns fastened_to) {
		this.fastened_to = fastened_to;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Dropdowns getCounty() {
		return county;
	}

	public void setCounty(Dropdowns county) {
		this.county = county;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getShelter() {
		return shelter;
	}

	public void setShelter(Boolean shelter) {
		this.shelter = shelter;
	}

	public Boolean getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Boolean advertisement) {
		this.advertisement = advertisement;
	}

	public Boolean getBench() {
		return bench;
	}

	public void setBench(Boolean bench) {
		this.bench = bench;
	}

	public Boolean getBike_rack() {
		return bike_rack;
	}

	public void setBike_rack(Boolean bike_rack) {
		this.bike_rack = bike_rack;
	}

	public Boolean getTrash_can() {
		return trash_can;
	}

	public void setTrash_can(Boolean trash_can) {
		this.trash_can = trash_can;
	}

	public Boolean getTime_table() {
		return time_table;
	}

	public void setTime_table(Boolean time_table) {
		this.time_table = time_table;
	}

	public Boolean getSystem_map() {
		return system_map;
	}

	public void setSystem_map(Boolean system_map) {
		this.system_map = system_map;
	}

	public ServiceRequest getWork_request() {
		return work_request;
	}

	public void setWork_request(ServiceRequest work_request) {
		this.work_request = work_request;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAdmin_comments() {
		return admin_comments;
	}

	public void setAdmin_comments(String admin_comments) {
		this.admin_comments = admin_comments;
	}

	public String getAdditional_information() {
		return additional_information;
	}

	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}

	public List<Dropdowns> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Dropdowns> routes) {
		this.routes = routes;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}
	
	
	

	// private Blob[] photo;

}
//TODO user_id, photo, service_request
