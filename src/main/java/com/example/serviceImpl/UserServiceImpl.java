package com.example.serviceImpl;



import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.UserDto;
import com.example.Entity.User;
import com.example.Repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto registerUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		 
		User userSaved = userRepository.save(user);
		return modelMapper.map(userSaved, UserDto.class);
		
		
		
	}

	

}
