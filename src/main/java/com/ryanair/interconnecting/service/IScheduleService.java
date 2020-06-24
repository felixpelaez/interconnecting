package com.ryanair.interconnecting.service;

import java.util.List;

import org.joda.time.DateTime;

import com.ryanair.interconnecting.model.Interconnection;
import com.ryanair.interconnecting.model.Route;
import com.ryanair.interconnecting.model.Schedule;
import com.ryanair.interconnecting.model.ScheduleTime;

public interface IScheduleService {
	public List<Schedule> getSchedule(String departure,String arrival,List<ScheduleTime> listScheduleTimes);
	public String replaceValues(String departure,String arrival,ScheduleTime scheduleTime);
	public List<Interconnection> filterSchedules0(String departure,String arrival,List<Route> connections0,DateTime departureDate,DateTime arrivalDate,List<ScheduleTime> listScheduleTimes);
	public List<Interconnection> filterSchedules(String departure,String connection,String arrival,List<Schedule> listSchedules01,List<Schedule> listSchedules02,DateTime departureDate,DateTime arrivalDate);
}