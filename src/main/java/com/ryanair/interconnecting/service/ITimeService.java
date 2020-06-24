package com.ryanair.interconnecting.service;

import java.util.List;

import org.joda.time.DateTime;

import com.ryanair.interconnecting.model.Interconnection;
import com.ryanair.interconnecting.model.Route;
import com.ryanair.interconnecting.model.Schedule;
import com.ryanair.interconnecting.model.ScheduleTime;

public interface ITimeService {
	public List<ScheduleTime> getScheduleTimes(DateTime departureDateTime,DateTime arrivalDateTime);
}