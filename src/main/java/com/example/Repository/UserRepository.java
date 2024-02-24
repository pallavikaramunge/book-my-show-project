package com.example.Repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
	
Optional<User>  findByEmail(String email);

}
