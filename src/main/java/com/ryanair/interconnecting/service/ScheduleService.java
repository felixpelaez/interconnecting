package com.ryanair.interconnecting.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanair.interconnecting.model.Day;
import com.ryanair.interconnecting.model.Flight;
import com.ryanair.interconnecting.model.Interconnection;
import com.ryanair.interconnecting.model.Leg;
import com.ryanair.interconnecting.model.Route;
import com.ryanair.interconnecting.model.Schedule;
import com.ryanair.interconnecting.model.ScheduleTime;
import com.ryanair.interconnecting.util.CTES;

public class ScheduleService implements IScheduleService {
	
	public List<Schedule> getSchedule(String departure,String arrival,
			List<ScheduleTime> listScheduleTimes) {
		ObjectMapper mapper = new ObjectMapper();
        List<Schedule> listSchedules = new ArrayList<Schedule>();        
        try {
        	for (ScheduleTime scheduleTime:listScheduleTimes) {
        		listSchedules.add(mapper.readValue(new URL(replaceValues(departure,arrival,scheduleTime)), Schedule.class));
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listSchedules;
	}
	
	public String replaceValues(String departure,String arrival,ScheduleTime scheduleTime) {
		String auxURL=CTES.SCHEDULE_URL;
		auxURL=StringUtils.replace(auxURL,"{departure}",departure);
		auxURL=StringUtils.replace(auxURL,"{arrival}",arrival);
		auxURL=StringUtils.replace(auxURL,"{year}",Integer.toString(scheduleTime.getYear()));
		auxURL=StringUtils.replace(auxURL,"{month}",Integer.toString(scheduleTime.getMonth()));
		return auxURL;
	}
	
	public List<Interconnection> filterSchedules0(String departure,String arrival,List<Route> connections0,DateTime departureDate,DateTime arrivalDate,List<ScheduleTime> listScheduleTimes) {
		DateTime departureLegTime1,arrivalLegTime1=new DateTime();		 
		List<Interconnection> listInterconnections = new ArrayList<Interconnection>();
		List<Schedule> listSchedules01=getSchedule(departure,arrival,listScheduleTimes);
		if (!((Schedule) listSchedules01.get(0)).getDays().isEmpty()){						
			for (Schedule schedule01: listSchedules01) {
				for (Day day01: schedule01.getDays()) {
					for (Flight flight01: day01.getFlights()) {
						departureLegTime1=new DateTime(departureDate.getYear(), schedule01.getMonth(), day01.getDay(), flight01.getDepartureHour(), flight01.getDepartureMinute(), 0, 0);
						if (departureLegTime1.compareTo(departureDate) > -1) {
							arrivalLegTime1=new DateTime(departureDate.getYear(), schedule01.getMonth(), day01.getDay(), flight01.getArrivalHour(), flight01.getArrivalMinute(), 0, 0);
							if(arrivalLegTime1.compareTo(arrivalDate) < 1) {
								listInterconnections.add(new Interconnection(0,Arrays.asList(new Leg(departure, arrival, departureLegTime1,arrivalLegTime1))));																																			
							}
						}
					}
				}
			}
		}
		return listInterconnections;
	}
	
	public List<Interconnection> filterSchedules(String departure,String connection,String arrival,List<Schedule> listSchedules01,
			List<Schedule> listSchedules02,DateTime departureDate,DateTime arrivalDate) {
		DateTime departureLegTime1,arrivalLegTime1,departureLegTime2,arrivalLegTime2=new DateTime();		 
		List<Interconnection> listInterconnections = new ArrayList<Interconnection>();
		if (!((Schedule) listSchedules01.get(0)).getDays().isEmpty() && 
				 !((Schedule) listSchedules02.get(0)).getDays().isEmpty()){						
			for (Schedule schedule01: listSchedules01) {
				for (Day day01: schedule01.getDays()) {
					for (Flight flight01: day01.getFlights()) {
						departureLegTime1=new DateTime(departureDate.getYear(), schedule01.getMonth(), day01.getDay(), flight01.getDepartureHour(), flight01.getDepartureMinute(), 0, 0);
						if (departureLegTime1.compareTo(departureDate) > -1) {
							arrivalLegTime1=new DateTime(departureDate.getYear(), schedule01.getMonth(), day01.getDay(), flight01.getArrivalHour(), flight01.getArrivalMinute(), 0, 0);
							for (Schedule schedule02: listSchedules02) {
								for (Day day02: schedule02.getDays()) {
									for (Flight flight02: day02.getFlights()) {
										departureLegTime2=new DateTime(arrivalDate.getYear(),schedule02.getMonth(),day02.getDay(),flight02.getDepartureHour(),flight02.getDepartureMinute(),0,0);
										if (arrivalLegTime1.plusHours(CTES.INTER_HOUR).compareTo(departureLegTime2) < 1) { 
											arrivalLegTime2=new DateTime(arrivalDate.getYear(),schedule02.getMonth(),day02.getDay(),flight02.getArrivalHour(),flight02.getArrivalMinute(),0,0);
											if(arrivalLegTime2.compareTo(arrivalDate) < 1) {
												listInterconnections.add(new Interconnection(1,Arrays.asList(new Leg(departure, connection, departureLegTime1,arrivalLegTime1), new Leg(connection, arrival,departureLegTime2,arrivalLegTime2))));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return listInterconnections;
	}

	
}
