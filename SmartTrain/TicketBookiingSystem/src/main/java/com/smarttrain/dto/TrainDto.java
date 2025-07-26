package com.smarttrain.dto;

import jakarta.validation.constraints.*;

public class TrainDto {

	 @NotBlank(message = "Train name is required")
	    private String name;

	    @NotBlank(message = "Source is required")
	    private String source;

	    @NotBlank(message = "Destination is required")
	    private String destination;

	    @Min(value = 1, message = "Seats must be at least 1")
	    private int seats;

		public TrainDto(@NotBlank(message = "Train name is required") String name,
				@NotBlank(message = "Source is required") String source,
				@NotBlank(message = "Destination is required") String destination,
				@Min(value = 1, message = "Seats must be at least 1") int seats) {
			super();
			this.name = name;
			this.source = source;
			this.destination = destination;
			this.seats = seats;
		}

		public TrainDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}
	    
	    
}
