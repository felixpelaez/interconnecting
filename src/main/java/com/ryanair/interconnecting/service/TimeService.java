package com.ryanair.interconnecting.service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.ryanair.interconnecting.model.ScheduleTime;

public class TimeService implements ITimeService{
	
	public List<ScheduleTime> getScheduleTimes(DateTime departureDateTime,DateTime arrivalDateTime){
		List<ScheduleTime> result = new ArrayList<ScheduleTime>();
		int years = arrivalDateTime.getYear() -  departureDateTime.getYear();
		if (years < 1) {
			for (int i=departureDateTime.getMonthOfYear();i <= arrivalDateTime.getMonthOfYear(); i++) {
				result.add(new ScheduleTime(arrivalDateTime.getYear(),i));
			}
		}else if (years==1){
			for (int i=departureDateTime.getMonthOfYear();i <= 12; i++) {
				result.add(new ScheduleTime(departureDateTime.getYear(),i));
			}
			for (int i=1;i <= arrivalDateTime.getMonthOfYear(); i++) {
				result.add(new ScheduleTime(arrivalDateTime.getYear(),i));
			}

		}
		return result;
	}

}
