package com.ryanair.interconnecting.controller;

import java.util.List;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryanair.interconnecting.model.Interconnection;
import com.ryanair.interconnecting.service.InterConnectionService;

@RestController
public class ServiceController {
   private InterConnectionService interService = new InterConnectionService();

   @GetMapping("/interconnections")
    public ResponseEntity<List<Interconnection>> getInterConnections(@RequestParam String departure,@RequestParam String arrival,
    		@RequestParam String departureDateTime,@RequestParam String arrivalDateTime) {	    
    	DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
		return ResponseEntity.ok(interService.getInterConnections(departure,arrival,formatter.parseDateTime(departureDateTime),formatter.parseDateTime(arrivalDateTime)));
    }
}