package com.example.Repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Serializable> {
    
	Optional<Payment> findById(Integer id);
}
