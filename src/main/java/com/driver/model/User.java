package com.driver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String password;
	
	
	private String phoneNumber;
	
	
	@OneToMany
	@JoinColumn
	private List<Reservation>  reservationList;


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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public List<Reservation> getReservationList() {
		return reservationList;
	}


	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}


	public User(int id, String name, String password, String phoneNumber, List<Reservation> reservation) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.reservationList = reservation;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
