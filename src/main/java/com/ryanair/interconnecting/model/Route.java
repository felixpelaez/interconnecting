package com.ryanair.interconnecting.model;

import java.util.List;

public class Route {
	private String airportFrom;
	private String airportTo;
	private String connectingAirport;
	private boolean newRoute;
	private boolean seasonalRoute;
	private String operator;
	private String group;
	private List<String> similarArrivalAirportCodes;
	private List<String> tags;
	private String carrierCode;
	
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(String airportFrom, String airportTo, String connectingAirport, boolean newRoute,
			boolean seasonalRoute, String operator, String group, List<String> similarArrivalAirportCodes,
			List<String> tags, String carrierCode) {
		super();
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		this.connectingAirport = connectingAirport;
		this.newRoute = newRoute;
		this.seasonalRoute = seasonalRoute;
		this.operator = operator;
		this.group = group;
		this.similarArrivalAirportCodes = similarArrivalAirportCodes;
		this.tags = tags;
		this.carrierCode = carrierCode;
	}

	public String getAirportFrom() {
		return airportFrom;
	}

	public void setAirportFrom(String airportFrom) {
		this.airportFrom = airportFrom;
	}

	public String getAirportTo() {
		return airportTo;
	}

	public void setAirportTo(String airportTo) {
		this.airportTo = airportTo;
	}

	public String getConnectingAirport() {
		return connectingAirport;
	}

	public void setConnectingAirport(String connectingAirport) {
		this.connectingAirport = connectingAirport;
	}

	public boolean isNewRoute() {
		return newRoute;
	}

	public void setNewRoute(boolean newRoute) {
		this.newRoute = newRoute;
	}

	public boolean isSeasonalRoute() {
		return seasonalRoute;
	}

	public void setSeasonalRoute(boolean seasonalRoute) {
		this.seasonalRoute = seasonalRoute;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public List<String> getSimilarArrivalAirportCodes() {
		return similarArrivalAirportCodes;
	}

	public void setSimilarArrivalAirportCodes(List<String> similarArrivalAirportCodes) {
		this.similarArrivalAirportCodes = similarArrivalAirportCodes;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportFrom == null) ? 0 : airportFrom.hashCode());
		result = prime * result + ((airportTo == null) ? 0 : airportTo.hashCode());
		result = prime * result + ((carrierCode == null) ? 0 : carrierCode.hashCode());
		result = prime * result + ((connectingAirport == null) ? 0 : connectingAirport.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + (newRoute ? 1231 : 1237);
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + (seasonalRoute ? 1231 : 1237);
		result = prime * result + ((similarArrivalAirportCodes == null) ? 0 : similarArrivalAirportCodes.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		Route other = (Route) obj;
		if (airportFrom == null) {
			if (other.airportFrom != null)
				return false;
		} else if (!airportFrom.equals(other.airportFrom))
			return false;
		if (airportTo == null) {
			if (other.airportTo != null)
				return false;
		} else if (!airportTo.equals(other.airportTo))
			return false;
		if (carrierCode == null) {
			if (other.carrierCode != null)
				return false;
		} else if (!carrierCode.equals(other.carrierCode))
			return false;
		if (connectingAirport == null) {
			if (other.connectingAirport != null)
				return false;
		} else if (!connectingAirport.equals(other.connectingAirport))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (newRoute != other.newRoute)
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (seasonalRoute != other.seasonalRoute)
			return false;
		if (similarArrivalAirportCodes == null) {
			if (other.similarArrivalAirportCodes != null)
				return false;
		} else if (!similarArrivalAirportCodes.equals(other.similarArrivalAirportCodes))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Route [airportFrom=" + airportFrom + ", airportTo=" + airportTo + ", connectingAirport="
				+ connectingAirport + ", newRoute=" + newRoute + ", seasonalRoute=" + seasonalRoute + ", operator="
				+ operator + ", group=" + group + ", similarArrivalAirportCodes=" + similarArrivalAirportCodes
				+ ", tags=" + tags + ", carrierCode=" + carrierCode + "]";
	}

	
}
