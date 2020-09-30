package com.nfta.stopsTransaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.model.Dropdowns;

@Service
public interface DropdownService {

	public String addDropdown(Dropdowns dropdown);
	
	public String deleteDropdown(Dropdowns dropdown);

	public List<Dropdowns> getDropdowns(String dropdownType);
}
