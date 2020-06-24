package com.ryanair.interconnecting.model;

import org.joda.time.Hours;

public class Flight {
	private String carrierCode;
	private int number;
	private String departureTime;
	private String arrivalTime;

	public Flight() {
		super();
	}
	public Flight(String carrierCode, int number, String departureTime, String arrivalTime) {
		super();
		this.carrierCode = carrierCode;
		this.number = number;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;

	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getDepartureHour() {
		return Integer.parseInt(departureTime.split(":")[0]);
	}

	public int getDepartureMinute() {
		return Integer.parseInt(departureTime.split(":")[1]);
	}

	public int getArrivalHour() {
		return Integer.parseInt(arrivalTime.split(":")[0]);
	}
	
	public int getArrivalMinute() {
		return Integer.parseInt(arrivalTime.split(":")[1]);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((carrierCode == null) ? 0 : carrierCode.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + number;
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
		Flight other = (Flight) obj;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (carrierCode == null) {
			if (other.carrierCode != null)
				return false;
		} else if (!carrierCode.equals(other.carrierCode))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [carrierCode=" + carrierCode + ", number=" + number + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + "]";
	}

}
