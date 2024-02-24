package com.example.Dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class MoviesDto {
	
private String category;
	
	private String genre;
	
	 private String movieName;
	
	
	private String movie_poster;
	
	private Double rating;
	
	private LocalDate release_date;
	
	private String country;

}
