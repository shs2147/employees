package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.EmployeeDetail;

public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail, Integer>{

	
}
