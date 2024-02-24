package com.example.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.BookTicketDto;
import com.example.Entity.BookTicket;
import com.example.Entity.Movies;
import com.example.Entity.Payment;
import com.example.Entity.User;
import com.example.Repository.BookTicketRepository;
import com.example.Repository.MoviesRepository;
import com.example.Repository.PaymentRepository;
import com.example.Repository.UserRepository;
import com.example.service.BookTicketService;

@Service
public class BookTicketServiceImpl implements BookTicketService {
	
@Autowired
BookTicketRepository bookTicketRepository;

@Autowired
UserRepository userRepository;

@Autowired
MoviesRepository moviesRepository;

@Autowired
PaymentRepository paymentRepository;

@Autowired
ModelMapper modelMapper;
	
	
	@Override
	public List<BookTicketDto> getAllTicket() {
		
		List<BookTicket>tickets = bookTicketRepository.findAll();
		return tickets.stream()
				.map(bookTicket ->modelMapper.map(bookTicket,BookTicketDto.class))
				.collect(Collectors.toList());
	}
	@Override
	public BookTicket ticketBooking(BookTicketDto bookTicketDto) {
		Optional<User> user = userRepository.findByEmail(bookTicketDto.getEmail());
		Movies movies = moviesRepository.findByMovieName(bookTicketDto.getMovieName());
				//.findByMovieName(bookTicketDto.getMovieName());
		Optional<Payment> payment  = paymentRepository.findById(bookTicketDto.getId());
		
		
		if(user.isPresent()&&payment.isPresent()) {
		BookTicket bookTicket = new BookTicket();
		
		bookTicket.setUser(user.get());
		bookTicket.setMovies(movies);
		bookTicket.setPayment(payment.get());
		BeanUtils.copyProperties(bookTicketDto, bookTicket);
		
		return bookTicketRepository.save(bookTicket);
		}else {
			throw new NoSuchElementException("No value present for user and payment");
		}
	}

	
	@Override
	public BookTicketDto getTicketById(Integer bookingId) {
		BookTicket bookTicket =bookTicketRepository.findById(bookingId).orElse(null);
	return bookTicket!= null?modelMapper.map(bookTicket, BookTicketDto.class):null;
	}

	@Override
	public void updateTicket(Integer bookingId, BookTicketDto bookTicketDto) {
		BookTicket existingSeatBooking = bookTicketRepository.findById(bookingId).orElse(null);
		if(existingSeatBooking!= null) {
			modelMapper.map(bookTicketDto, existingSeatBooking);
			existingSeatBooking.setId(bookingId);
			bookTicketRepository.save(existingSeatBooking);
		}	
		
	}

	@Override
	public void deleteTicket(Integer bookingId) {
		bookTicketRepository.deleteById(bookingId);
		
	}

}
