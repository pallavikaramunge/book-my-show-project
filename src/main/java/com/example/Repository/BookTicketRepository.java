package com.example.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.BookTicket;

@Repository
public interface BookTicketRepository extends JpaRepository<BookTicket, Serializable>{

}
