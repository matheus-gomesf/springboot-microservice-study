package com.br.mgf.employeeservice.controller;

import com.br.mgf.employeeservice.entity.dto.EmployeeDTO;
import com.br.mgf.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO EmployeeDTO) {
        val Employee = employeeService.createEmployee(EmployeeDTO);
        return new ResponseEntity<>(Employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO EmployeeDTO, @PathVariable UUID id) {
        val Employee = employeeService.updateEmployee(id, EmployeeDTO);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> list() {
        List<EmployeeDTO> EmployeeDTOList = employeeService.listEmployees();
        return new ResponseEntity<>(EmployeeDTOList, HttpStatus.OK);
    }
}
