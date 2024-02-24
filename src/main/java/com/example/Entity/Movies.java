package com.example.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movies {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String category;
	
	private String genre;
	
	 @Column(name = "movie_name")
	 private String movieName;
	
    @Column(length = 255)
	private String movie_poster;
	
	private Double rating;
	
	private LocalDate release_date;
	
	private String country;
	
	@OneToMany(mappedBy = "movies",cascade = CascadeType.ALL)
	private List<BookTicket> bookTicket = new ArrayList<>();
}
