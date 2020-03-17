package com.nfta.stopsTransaction.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nfta.stopsTransaction.model.Route;

@Component
public interface RoutesDao {
	public List<Route> getRoutes();
    public String save(Route t);
    public void update(Route t);
    public void delete(Route t);
}
