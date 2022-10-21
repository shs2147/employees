package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDetailDto;
import com.example.demo.repository.EmployeeDetailRepository;
import com.example.demo.user.EmployeeDetail;

@Service

public class EmployeeDetailServices {
	@Autowired
	private EmployeeDetailRepository employeeDetailRepository;
	
	public void details(EmployeeDetailDto employeeDetailDto) {
		
		employeeDetailRepository.save (employeeDetailDtoTOemployeeDetail(employeeDetailDto));
		
	}
	
	public List<EmployeeDetailDto>getEmplList(){
		List<EmployeeDetail>detail=this.employeeDetailRepository.findAll();
		List<EmployeeDetailDto>dtoDetail=detail.stream().map(dot ->this.employeeDetailToemployeeDetailDto(dot)).collect(Collectors.toList());
		 return dtoDetail;
	}
	
	
	public void deleteEmployee(int id ) {
		employeeDetailRepository.deleteById(id);
		
		
		
	}

	private EmployeeDetail employeeDetailDtoTOemployeeDetail(EmployeeDetailDto employeeDetailDto) {
		EmployeeDetail emp=new EmployeeDetail();
		emp.setId(employeeDetailDto.getId());
		emp.setName(employeeDetailDto.getName());
		
		return emp;
	}
	
	private EmployeeDetailDto employeeDetailToemployeeDetailDto(EmployeeDetail employeeDetail) {
		EmployeeDetailDto empDto=new EmployeeDetailDto();
		empDto.setId(employeeDetail.getId());
		empDto.setName(employeeDetail.getName());
		
		return empDto;
	}
}
