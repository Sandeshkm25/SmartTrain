package com.smarttrain.entity;


import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "train_id", nullable = false)
	private Train train;
	private LocalDate travelDate;
	private int seatCount;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ticket> tickets;

	public Booking(User user, Train train, LocalDate travelDate, int seatCount, List<Ticket> tickets) {
		super();
		this.user = user;
		this.train = train;
		this.travelDate = travelDate;
		this.seatCount = seatCount;
		this.tickets = tickets;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	public Train getTrain() {
		return train;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
}
