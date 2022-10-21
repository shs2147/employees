package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDetailDto;
import com.example.demo.services.EmployeeDetailServices;

@RestController
public class employeeController {
	@Autowired
	private EmployeeDetailServices employeeDetailServices;
	 
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDetailDto>saveDetail(@RequestBody EmployeeDetailDto employeeDetailDto){
		employeeDetailServices.details(employeeDetailDto);
				return new ResponseEntity<>(employeeDetailDto,HttpStatus.CREATED);
			
	}
	@DeleteMapping("/employee/{employeeId}")
	public void deleteId(@PathVariable("employeeId") int id) {
		employeeDetailServices.deleteEmployee(id);		
		
	}

}
