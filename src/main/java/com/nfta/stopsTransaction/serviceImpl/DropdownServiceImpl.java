package com.nfta.stopsTransaction.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfta.stopsTransaction.dao.DropdownDao;
import com.nfta.stopsTransaction.model.Dropdowns;
import com.nfta.stopsTransaction.service.DropdownService;

@Service
public class DropdownServiceImpl implements DropdownService {
	
	@Autowired
	DropdownDao dropdownDao;
	
	private static List<Dropdowns> dropdownlist = new ArrayList<Dropdowns>();
	
	@Override
	public String addDropdown(Dropdowns dropdown) {
		return dropdownDao.save(dropdown);
	}

	@Override
	public List<Dropdowns> getDropdowns(String dropdownType) {
		dropdownlist = dropdownDao.getDropdown(dropdownType);
		return dropdownlist;
	}

	@Override
	public String deleteDropdown(Dropdowns dropdown) {
		return dropdownDao.delete(dropdown);
	}

}
