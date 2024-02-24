package com.example.service;

import java.util.List;

import com.example.Dto.BookTicketDto;
import com.example.Entity.BookTicket;




public interface BookTicketService {
	
	List<BookTicketDto>getAllTicket();
	
    public BookTicket ticketBooking(BookTicketDto bookTicketDto);
    
    BookTicketDto getTicketById(Integer bookingId);
    
    void updateTicket(Integer bookingId,BookTicketDto bookTicketDto);
    
    void deleteTicket(Integer bookingId);

}
