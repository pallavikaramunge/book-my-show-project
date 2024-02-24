package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.MoviesDto;
import com.example.Entity.Movies;
import com.example.service.MoviesService;

@RestController
@RequestMapping("/api/movies")
public class MoviesRestController {
	
	@Autowired
	MoviesService moviesService;
	
	@PostMapping("/add")
	public ResponseEntity<MoviesDto> addMovies(@RequestBody MoviesDto moviesDto ){
		
		return new ResponseEntity<MoviesDto>(moviesService.addMovies(moviesDto),HttpStatus.CREATED);
		
		/*try {
		   moviesService.addMovies(moviesDto);
		return new ResponseEntity<>("movies added sucessfully",HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>("Error adding movie" +e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		*/
	}
	
	@GetMapping("/search/{movieName}")
	public ResponseEntity<List<Movies>>getMoviesNameContainingSubstring(@PathVariable String movieName){
List<Movies>findMovies	=	moviesService.findByMovieNameContaining(movieName);
		
		if(!findMovies.isEmpty()) {
			return ResponseEntity.ok(findMovies);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	  @GetMapping("/{movieName}")
	    public Movies getMovieByMovieName(@PathVariable String movieName) {
	        return moviesService.getMovieByMovieName(movieName);
	    }
	/*
	 @GetMapping("/{id}")
	    public ResponseEntity<MoviesDto> getMovieById(@PathVariable Integer id) {
	        try {
	            MoviesDto movie = moviesService.getMovieById(id);
	            return ResponseEntity.ok(movie);
	        } catch (ResourceNotFoundException ex) {
	           
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	*/

}
