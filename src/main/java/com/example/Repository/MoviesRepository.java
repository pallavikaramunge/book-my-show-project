package com.example.Repository;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Serializable> {
	
	public Movies findByMovieName(String movieName);

	
	 List<Movies>findByMovieNameContaining(String str);
	

}
