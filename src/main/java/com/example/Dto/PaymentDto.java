package com.example.Dto;

import java.util.List;

import lombok.Data;

@Data
public class PaymentDto {
	
	 private double totalPrice;
	 private double price;
	 private String fname;
	 private String email;
	 private String movieName;
	 private String movie_poster;
	 
	 private String location;
	 private String theater;
	 private List<String> bookedSeats;
	 private String time;
	 private String food;
	 private String cardHolder;
	 private String cardNo;
	 private String expDate;

}
