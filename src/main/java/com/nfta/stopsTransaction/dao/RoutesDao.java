package com.nfta.stopsTransaction.dao;

import java.util.List;
import com.nfta.stopsTransaction.model.Route;

public interface RoutesDao {
	public List<Route> getRoutes();
    public int save(Route t);
    public void update(Route t);
    public void delete(Route t);
}
