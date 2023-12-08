package com.br.mgf.departamentservice.controller;

import com.br.mgf.departamentservice.entity.dto.DepartmentDTO;
import com.br.mgf.departamentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> create(@RequestBody DepartmentDTO departmentDTO) {
        val department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> update(@RequestBody DepartmentDTO departmentDTO, @PathVariable UUID id) {
        val department = departmentService.updateDepartment(id, departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> list() {
        List<DepartmentDTO> departmentDTOList = departmentService.listDepartments();
        return new ResponseEntity<>(departmentDTOList, HttpStatus.OK);
    }
}
