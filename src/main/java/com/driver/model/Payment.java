package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="payment")
public class Payment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private boolean paymentCompleted;
	
	
	private PaymentMode paymentMode;
	
	
	@OneToOne
	@JoinColumn
	private Reservation resevation;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isPaymentCompleted() {
		return paymentCompleted;
	}


	public void setPaymentCompleted(boolean paymentCompleted) {
		this.paymentCompleted = paymentCompleted;
	}


	public PaymentMode getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}


	public Reservation getResevation() {
		return resevation;
	}


	public void setReservation(Reservation resevation) {
		this.resevation = resevation;
	}


	public Payment(int id, boolean paymentCompleted, PaymentMode paymentMode, Reservation resevation) {
		super();
		this.id = id;
		this.paymentCompleted = paymentCompleted;
		this.paymentMode = paymentMode;
		this.resevation = resevation;
	}


	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
