package com.nfta.stopsTransaction.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.Dropdowns;

@Component
public interface DropdownDao {

	public List<Dropdowns> getDropdown(String dropdown_type);

	public String save(Dropdowns dropdown);

	public void update(Dropdowns dropdown);

	public String delete(Dropdowns dropdown);
}
