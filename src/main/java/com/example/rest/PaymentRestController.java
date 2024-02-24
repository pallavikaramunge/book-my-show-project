package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.PaymentDto;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/process")
	public ResponseEntity<String>processPayment(@RequestBody PaymentDto paymentDto){
	boolean paymentProcessed = 	paymentService.paymentProcess(paymentDto);
	if(paymentProcessed) {
		return new ResponseEntity<String>("Sucessfully",HttpStatus.OK);
		
	}else {
		return new ResponseEntity<String>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	}
	@GetMapping("/{id}")
	public ResponseEntity<String>getPaymentDetailsById(@PathVariable Integer id ){
	String paymentDetails = paymentService.getPaymentDetaildById(id);
	
	if(paymentDetails!= null) {
		return new ResponseEntity<String>(paymentDetails,HttpStatus.OK);
		
	}else {
		return new ResponseEntity<String>(paymentDetails,HttpStatus.NOT_FOUND);
	}
	
	
	}

}











