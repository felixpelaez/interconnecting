package com.ryanair.interconnecting.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanair.interconnecting.model.Route;
import com.ryanair.interconnecting.util.CTES;

public class RouteService implements IRouteService {
	List<Route> routes;
	public List<Route> getRoutes0Request(String airportFrom, String airportTo) {
    	List<Route> directRoutes = new ArrayList<Route>();
        try {
	        	//Get all routes with departure=airportFrom
	        	directRoutes=this.routes.stream().filter(
	    				route -> route.getAirportFrom().equals(airportFrom) && route.getAirportTo().equals(airportTo))
	    				.collect(Collectors.toList());
        } catch (Exception e) {
        		e.printStackTrace();
        }
        return directRoutes;
	}

	
	public List<Route> getRoutes1Request(String airportFrom, String airportTo) {
    	List<Route> fromToRoutes = new ArrayList<Route>();
        try {
	        	//Get all routes with departure=airportFrom
	        	List<Route> fromRoutes=this.routes.stream().filter(
	    				route -> route.getAirportFrom().equals(airportFrom))
	    				.collect(Collectors.toList());
	        	
	        	//Get all routes with arrival=airportTo
	        	List<Route> toRoutes=this.routes.stream().filter(
	    				route -> route.getAirportTo().equals(airportTo))
	    				.collect(Collectors.toList());
	        	
	        	//GeT all routes with departure=airportFrom && leg(One Step) && arrival=airportTo
	        	for (Route route01: fromRoutes) {
		        	fromToRoutes.addAll(toRoutes.stream().filter(
		    				route02 -> route02.getAirportFrom().equals(route01.getAirportTo()))
		    				.collect(Collectors.toList()));        		
	        	}        	
        } catch (Exception e) {
        		e.printStackTrace();
        }
        return fromToRoutes;
	}
	
	@Override
	public List<Route> initRoutes() {
		ObjectMapper mapper = new ObjectMapper();
        List<Route> listRoutes = new ArrayList<>();
        try {
            listRoutes=(List<Route>) mapper.readValue(new URL(CTES.ROUTES_URL), new TypeReference<List<Route>>(){});            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listRoutes;
	}

	@Override
	public List<Route> getRoutes() {
        return this.routes;
	}

	@Override
	public void setRoutes(List<Route> paramRoutes) {
		// TODO Auto-generated method stub
		this.routes=paramRoutes;
	}
	
}
