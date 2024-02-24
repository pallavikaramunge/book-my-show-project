package com.example.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.PaymentDto;
import com.example.Entity.Payment;
import com.example.Repository.PaymentRepository;
import com.example.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public boolean paymentProcess(PaymentDto paymentDto) {
	
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDto, payment);
		
		paymentRepository.save(payment);
		return true;
		
	}

	@Override
	public String getPaymentDetaildById(int id) {
	Optional<Payment> paymentDetailedById = paymentRepository.findById(id);
	
	if(paymentDetailedById.isPresent()){
		paymentDetailedById.get();
		return "Payment Details Found";
		}else {
			return"Payment Detais Not Found For Id";
		}
	}

}
