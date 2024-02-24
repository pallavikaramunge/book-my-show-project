package com.example.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {

}
