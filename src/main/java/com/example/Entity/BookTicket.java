package com.example.Entity;

import java.util.List;


import javax.persistence.CollectionTable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "book_ticket")
public class BookTicket {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		private String location;
		
		private String theater;
		
		 @ElementCollection
		 @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "book_ticket_id"))
		private List<String> bookedSeats;
		
		private String time;
		private String food;
		private Double price;
		
		
		private Double totalPrice;
		
		
		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;
		
		@OneToOne
		@JoinColumn(name = "payment_id")
		private Payment payment;
		
		@ManyToOne
		@JoinColumn(name = "movies_id")
		private Movies movies;
		
		
		
		

}
