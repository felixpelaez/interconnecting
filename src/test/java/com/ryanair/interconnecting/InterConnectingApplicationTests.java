package com.ryanair.interconnecting;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanair.interconnecting.model.Interconnection;
import com.ryanair.interconnecting.model.Route;
import com.ryanair.interconnecting.model.Schedule;
import com.ryanair.interconnecting.model.ScheduleTime;
import com.ryanair.interconnecting.service.IRouteService;
import com.ryanair.interconnecting.service.IScheduleService;
import com.ryanair.interconnecting.service.InterConnectionService;
import com.ryanair.interconnecting.service.RouteService;
import com.ryanair.interconnecting.service.ScheduleService;
import com.ryanair.interconnecting.util.CTES;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterConnectingApplicationTests {	
    private InterConnectionService interService = new InterConnectionService();
    IRouteService routeService = new RouteService();
    IScheduleService scheduleService = new ScheduleService();
	
	@Test
	public void connectionRoute() {
		ObjectMapper mapper = new ObjectMapper();
        List<Route> listRoutes = new ArrayList<>();
        try {
            listRoutes=(List<Route>) mapper.readValue(new URL(CTES.ROUTES_URL), new TypeReference<List<Route>>(){});            
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(listRoutes.size()).isGreaterThan(0);
	}
	
	@Test
	public void connectionSchedule() {
		ObjectMapper mapper = new ObjectMapper();
		boolean result=true;
        try {
        	 ScheduleTime scheduleTime = new ScheduleTime((new DateTime()).getYear(),(new DateTime()).getMonthOfYear());
        	 @SuppressWarnings("unchecked")
			 Schedule schedule=(Schedule) mapper.readValue(new URL(scheduleService.replaceValues("DUB","WRO",scheduleTime)), Schedule.class);
        } catch (IOException e) {
            e.printStackTrace();
            result=false;
        }        
        assertThat(result).isTrue();
	}

	@Test
	public void getConnections() {
		boolean result=true;
        try {
   	   		List<Interconnection> listInterConnections = interService.getInterConnections("ZAZ","RAK",
     	    		new DateTime(), new DateTime().plusDays(2));
    	 } catch (Exception e) {
            e.printStackTrace();
            result=false;
         }        
         assertThat(result).isTrue();
	}
	
}