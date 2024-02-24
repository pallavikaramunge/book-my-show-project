package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.BookTicketDto;
import com.example.Entity.BookTicket;
import com.example.service.BookTicketService;

@RestController
@RequestMapping("/api/bookticket")
public class BookTicketRestController {
	
	@Autowired
	BookTicketService bookTicketService;
	
	
	@PostMapping("/ticket")
	public ResponseEntity<String>ticketBooking(@RequestBody BookTicketDto bookTicketDto){
		
	     BookTicket bookedTicket =  bookTicketService.ticketBooking(bookTicketDto);
	     
	if(bookedTicket != null ) {
		
	return new ResponseEntity<String>("Ticket booked Sucessfully",HttpStatus.CREATED);
	
	}else {
	
	 return new ResponseEntity<String>("Failed to book Ticket" ,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
	
	@GetMapping()
	public ResponseEntity<List<BookTicketDto>>getAllTicket(){
		
   List<BookTicketDto> bookTicket = bookTicketService.getAllTicket();
		
		return new ResponseEntity<List<BookTicketDto>>(bookTicket,HttpStatus.OK);
		
	}
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookTicketDto>getTicketById(@PathVariable Integer bookingId){
		
		BookTicketDto seatBooking = bookTicketService.getTicketById(bookingId);
		
		return seatBooking!= null ?
			new	ResponseEntity<>(seatBooking,HttpStatus.OK):
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{bookindId}")
	public ResponseEntity<Void> updateticket(@PathVariable Integer bookingId,
			@RequestBody BookTicketDto bookTicketDto){
		
		bookTicketService.updateTicket(bookingId, bookTicketDto);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/bookingId")
	public ResponseEntity<Void>deleteTicket(@PathVariable Integer bookingId,@RequestBody BookTicketDto bookTicketDto){
		
		bookTicketService.deleteTicket(bookingId);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	

}
















