package com.example.service;

import com.example.Dto.PaymentDto;

public interface PaymentService {
	
	public boolean paymentProcess(PaymentDto paymentDto);
	
	public String getPaymentDetaildById(int id);

}
