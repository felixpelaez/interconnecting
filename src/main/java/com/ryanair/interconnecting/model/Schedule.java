package com.ryanair.interconnecting.model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
	private int month;
	private List<Day> days = new ArrayList<Day>();
	public Schedule() {
		super();
	}
	public Schedule(int month, List<Day> days) {
		super();
		this.month = month;
		this.days = days;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public List<Day> getDays() {
		return days;
	}
	public void setDays(List<Day> days) {
		this.days = days;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + month;
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
		Schedule other = (Schedule) obj;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (month != other.month)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Schedule [month=" + month + ", days=" + days + "]";
	}

}
