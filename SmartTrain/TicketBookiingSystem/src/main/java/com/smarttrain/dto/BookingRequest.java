package com.smarttrain.dto;

	import java.time.LocalDate;
	import java.util.List;

	public class BookingRequest {
	    private Long userId;
	    private Long trainId;
	    private LocalDate travelDate;
	    private int seatCount;
	    private List<TicketRequest> tickets;
		public BookingRequest(Long userId, Long trainId, LocalDate travelDate, int seatCount,
				List<TicketRequest> tickets) {
			super();
			this.userId = userId;
			this.trainId = trainId;
			this.travelDate = travelDate;
			this.seatCount = seatCount;
			this.tickets = tickets;
		}
		public BookingRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getTrainId() {
			return trainId;
		}
		public void setTrainId(Long trainId) {
			this.trainId = trainId;
		}
		public LocalDate getTravelDate() {
			return travelDate;
		}
		public void setTravelDate(LocalDate travelDate) {
			this.travelDate = travelDate;
		}
		public int getSeatCount() {
			return seatCount;
		}
		public void setSeatCount(int seatCount) {
			this.seatCount = seatCount;
		}
		public List<TicketRequest> getTickets() {
			return tickets;
		}
		public void setTickets(List<TicketRequest> tickets) {
			this.tickets = tickets;
		}

	   
	}

