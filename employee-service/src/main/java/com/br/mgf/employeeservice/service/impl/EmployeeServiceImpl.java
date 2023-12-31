package com.br.mgf.employeeservice.service.impl;

import com.br.mgf.employeeservice.entity.dto.APIResponseDto;
import com.br.mgf.employeeservice.entity.dto.EmployeeDTO;
import com.br.mgf.employeeservice.repository.EmployeeRepository;
import com.br.mgf.employeeservice.service.ApiClient;
import com.br.mgf.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.br.mgf.employeeservice.mapper.EmployeeMapper.EMPLOYEE_MAPPER;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ApiClient apiClient;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO EmployeeDTO) {
        val entity = EMPLOYEE_MAPPER.dtoToEntity(EmployeeDTO);

        return EMPLOYEE_MAPPER.entityToDto(employeeRepository.save(entity));
    }

    @Override
    public EmployeeDTO updateEmployee(UUID id, EmployeeDTO EmployeeDTO) {
        employeeRepository.findById(id);

        val toSave = EMPLOYEE_MAPPER.dtoToEntity(EmployeeDTO);
        toSave.setUuid(id);

        return EMPLOYEE_MAPPER.entityToDto(employeeRepository.save(toSave));
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> listEmployees() {
        return employeeRepository.findAll().stream().map(EMPLOYEE_MAPPER::entityToDto).toList();
    }

    @Override
    public APIResponseDto getById(UUID id) {
        val employee = employeeRepository.findById(id);

        val department = apiClient.getDepartmentByCode(employee.get().getDepartmentCode());

        return new APIResponseDto(EMPLOYEE_MAPPER.entityToDto(employee.get()), department);
    }
}
