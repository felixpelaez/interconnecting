package com.ryanair.interconnecting.model;

import java.util.ArrayList;
import java.util.List;

public class Interconnection {
	int stops;
	List<Leg> legs = new ArrayList<>();
	public Interconnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interconnection(int stops, List<Leg> legs) {
		super();
		this.stops = stops;
		this.legs = legs;
	}
	
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public List<Leg> getLegs() {
		return legs;
	}
	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((legs == null) ? 0 : legs.hashCode());
		result = prime * result + stops;
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
		Interconnection other = (Interconnection) obj;
		if (legs == null) {
			if (other.legs != null)
				return false;
		} else if (!legs.equals(other.legs))
			return false;
		if (stops != other.stops)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Interconnection [stops=" + stops + ", legs=" + legs + "]";
	}
	
}
