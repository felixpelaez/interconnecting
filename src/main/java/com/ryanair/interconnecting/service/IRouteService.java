package com.ryanair.interconnecting.service;

import java.util.List;
import com.ryanair.interconnecting.model.Route;

public interface IRouteService {
	public List<Route> initRoutes();
	public void setRoutes(List<Route> paramRoutes);
	public List<Route> getRoutes();
	public List<Route> getRoutes0Request(String airportFrom, String airportTo);
	public List<Route> getRoutes1Request(String airportFrom, String airportTo);
}
