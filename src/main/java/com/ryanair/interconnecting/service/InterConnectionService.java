package com.ryanair.interconnecting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import com.ryanair.interconnecting.model.Interconnection;
import com.ryanair.interconnecting.model.Route;
import com.ryanair.interconnecting.model.Schedule;
import com.ryanair.interconnecting.model.ScheduleTime;

public class InterConnectionService {
    ITimeService timeService = new TimeService();
    IRouteService routeService = new RouteService();
    IScheduleService scheduleService = new ScheduleService();
	Schedule schedule;
			  
	public InterConnectionService() {
		super();
		routeService.setRoutes(routeService.initRoutes().stream().filter(
				route -> route.getOperator().equals("RYANAIR") && route.getConnectingAirport()==null)
				.collect(Collectors.toList()));
	}


	public List<Interconnection> getInterConnections(String departure,String arrival,
			 DateTime departureDate,DateTime arrivalDate) {
    	List<ScheduleTime> listScheduleTimes = timeService.getScheduleTimes(departureDate, arrivalDate);
    	List<Route> connections0=routeService.getRoutes0Request(departure, arrival);
		List<Route> connections= routeService.getRoutes1Request(departure, arrival);
		List<Interconnection> listInterconnections = new ArrayList<Interconnection>();
		listInterconnections.addAll(scheduleService.filterSchedules0(departure,arrival,connections0,departureDate,arrivalDate,listScheduleTimes));
		for (Route route: connections) {
			listInterconnections.addAll(scheduleService.filterSchedules(departure,route.getAirportFrom(),arrival,
					scheduleService.getSchedule(departure,route.getAirportFrom(),listScheduleTimes),
					scheduleService.getSchedule(route.getAirportFrom(),route.getAirportTo(),listScheduleTimes),
					departureDate,arrivalDate));	
		}	 
        return listInterconnections;
	 }	
}
