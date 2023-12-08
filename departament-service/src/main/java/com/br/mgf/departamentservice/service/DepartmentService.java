package com.br.mgf.departamentservice.service;

import com.br.mgf.departamentservice.entity.dto.DepartmentDTO;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(UUID ID, DepartmentDTO departmentDTO);
    void deleteDepartment(UUID id);

    List<DepartmentDTO> listDepartments();
}
