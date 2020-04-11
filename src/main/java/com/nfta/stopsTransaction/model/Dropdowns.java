package com.nfta.stopsTransaction.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dropdowns")
@Data
public class Dropdowns implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5322546831120583581L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dropdown_id;
	private String dropdown_type;
	private Integer dropdown_value;
	private String display_name;
	
	public Integer getDropdown_id() {
		return dropdown_id;
	}
	public void setDropdown_id(Integer dropdown_id) {
		this.dropdown_id = dropdown_id;
	}
	public String getDropdown_type() {
		return dropdown_type;
	}
	public void setDropdown_type(String dropdown_type) {
		this.dropdown_type = dropdown_type;
	}
	public Integer getDropdown_value() {
		return dropdown_value;
	}
	public void setDropdown_value(Integer dropdown_value) {
		this.dropdown_value = dropdown_value;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

			
}
