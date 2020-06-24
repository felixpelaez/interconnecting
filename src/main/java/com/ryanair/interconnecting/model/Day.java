package com.ryanair.interconnecting.model;

import java.util.ArrayList;
import java.util.List;

public class Day {
	private int day;
	private List<Flight> flights = new ArrayList<Flight>();
	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Day(int day, List<Flight> flights) {
		super();
		this.day = day;
		this.flights = flights;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((flights == null) ? 0 : flights.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		if (day != other.day)
			return false;
		if (flights == null) {
			if (other.flights != null)
				return false;
		} else if (!flights.equals(other.flights))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Day [day=" + day + ", flights=" + flights + "]";
	}
	
}
