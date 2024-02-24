package com.example.Dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserDto {

	@NotEmpty(message = "fname is mandatory")
	 private String fname;
	
	@NotEmpty(message = "lname is mandatory")
	 private String lname;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private LocalDate dob;
	
	@NotEmpty(message = "email id is required")
	@Email(message = "Enter valid Email Id")
	 private String email;
	
	@NotNull(message = "password is required")
	@Size(min =3,max = 10,message = "Password should be in between 3 to 10 character")
	 private String password;
}
