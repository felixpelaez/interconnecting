package com.ryanair.interconnecting.model;

public class ScheduleTime {
	int year;
	int month;
	public ScheduleTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleTime(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + month;
		result = prime * result + year;
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
		ScheduleTime other = (ScheduleTime) obj;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScheduleTime [year=" + year + ", month=" + month + "]";
	}
	

}
