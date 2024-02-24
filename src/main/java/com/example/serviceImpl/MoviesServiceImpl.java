package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.MoviesDto;
import com.example.Entity.Movies;
import com.example.Repository.MoviesRepository;
import com.example.exception.ResourceNotFoundException;
import com.example.service.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	MoviesRepository moviesRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	
	List<Movies>movie = new ArrayList<Movies>();

	@Override
	public MoviesDto addMovies(MoviesDto moviesDto) {
		Movies movies = modelMapper.map(moviesDto, Movies.class);
		Movies movieSaves = moviesRepository.save(movies);
		return modelMapper.map(movieSaves, MoviesDto.class);
		
	}
		
	
	


	@Override
	public MoviesDto updateMovie(MoviesDto moviesDto, Integer id) {
		Movies movies= moviesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movies", "id", id));
		movies.setMovieName(moviesDto.getMovieName()!=null ? moviesDto.getMovieName() : movies.getMovieName());
		movies.setMovie_poster(moviesDto.getMovie_poster()!=null ? moviesDto.getMovie_poster() : movies.getMovie_poster());
		movies.setCategory(moviesDto.getCategory()!=null ? moviesDto.getCategory() : movies.getCategory());
		movies.setRating(moviesDto.getRating()!=0 ? moviesDto.getRating() : movies.getRating());
		movies.setCountry(moviesDto.getCountry()!=null ? moviesDto.getCountry() : movies.getCountry());
		movies.setGenre(moviesDto.getGenre()!=null ? moviesDto.getGenre() : movies.getGenre());
		movies.setRelease_date(moviesDto.getRelease_date()!=null ? moviesDto.getRelease_date() : movies.getRelease_date());
		
		Movies updatedMovie= moviesRepository.save(movies);
		
		return modelMapper.map(updatedMovie, MoviesDto.class);
	}

	




	
	@Override
	public Movies getMovieByMovieName(String movieName) {
		 return moviesRepository.findByMovieName(movieName);
	}

	@Override
	public List<Movies> findByMovieNameContaining(String str) {
		 return moviesRepository.findByMovieNameContaining(str);
	}




	



	}




	




	


