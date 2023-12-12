package com.br.mgf.employeeservice.service;


import com.br.mgf.employeeservice.entity.dto.APIResponseDto;
import com.br.mgf.employeeservice.entity.dto.EmployeeDTO;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO EmployeeDTO);
    EmployeeDTO updateEmployee(UUID ID, EmployeeDTO EmployeeDTO);
    void deleteEmployee(UUID id);

    List<EmployeeDTO> listEmployees();

    APIResponseDto getById(UUID id);
}
