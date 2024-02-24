package com.example.service;

import java.util.List;

import com.example.Dto.MoviesDto;
import com.example.Entity.Movies;


public interface MoviesService {
	
	public MoviesDto addMovies(MoviesDto moviesDto);
	
	  Movies getMovieByMovieName(String movieName);
	  
	  List<Movies> findByMovieNameContaining(String str);
	
	
	

	MoviesDto updateMovie(MoviesDto moviesDto,Integer id);

	//public MoviesDto getMovieById(Integer id);
	
	//List<MoviesDto> getAllMovie();
	
	
	
	//void deleteMovie(Integer id);
	
	
	

}
