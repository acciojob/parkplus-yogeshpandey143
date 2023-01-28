package com.driver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parkngLot")
public class ParkingLot {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String name;
	private String address;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy ="parkingLot")
	private List<Spot> spotList;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Spot> getSpotList() {
		return spotList;
	}


	public void setSpotList(List<Spot> spotList) {
		this.spotList = spotList;
	}


	public ParkingLot(int id, String name, String address, List<Spot> spotList) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.spotList = spotList;
	}


	public ParkingLot() {
		super();
		// TODO Auto-generated constructor stub
	}

}
