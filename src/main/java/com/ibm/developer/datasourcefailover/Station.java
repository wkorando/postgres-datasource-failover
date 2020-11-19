package com.ibm.developer.datasourcefailover;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class Station {
	@Id
	private int id;
	private String station_code;

	public Station() {
	}

	public Station(int id, String station_code) {
		this.id = id;
		this.station_code = station_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStation_code() {
		return station_code;
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}

}
