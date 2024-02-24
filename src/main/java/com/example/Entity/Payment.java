package com.example.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message ="cardHolder name is mandatory")
	@Column(name = "card_holder")
	private String cardHolder;
	
	@NotEmpty(message ="cardNo is mandatory")
	@Column(name = "card_no")
	private String cardNo;
	
	@NotEmpty(message ="ExpDate is mandatory")
	@Column(name = "exp_date")
	private String expDate;
	
	@OneToOne(mappedBy = "payment",cascade = CascadeType.ALL)
	private BookTicket bookTicket;

}
