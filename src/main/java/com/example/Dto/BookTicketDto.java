package com.example.Dto;

import java.util.List;

import lombok.Data;

@Data
public class BookTicketDto {
	
	private Integer id;
	
	private String fname ;
	private String email ;
	
	private String movieName ;
	
	private String movie_poster ;
	
	private String location ;
	private String theater ;
	private List<String> bookedSeats ;
	private String time ;
	private String food ;
	private double price ;
	private double totalPrice ;
	

}
