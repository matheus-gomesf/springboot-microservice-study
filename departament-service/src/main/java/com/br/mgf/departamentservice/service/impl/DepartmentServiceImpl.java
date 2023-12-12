package com.br.mgf.departamentservice.service.impl;

import com.br.mgf.departamentservice.entity.dto.DepartmentDTO;
import com.br.mgf.departamentservice.repository.DepartmentRepository;
import com.br.mgf.departamentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.br.mgf.departamentservice.mapper.DepartmentMapper.DEPARTMENT_MAPPER;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        val entity = DEPARTMENT_MAPPER.dtoToEntity(departmentDTO);

        return DEPARTMENT_MAPPER.entityToDto(departmentRepository.save(entity));
    }

    @Override
    public DepartmentDTO updateDepartment(UUID id, DepartmentDTO departmentDTO) {
        departmentRepository.findById(id);

        val toSave = DEPARTMENT_MAPPER.dtoToEntity(departmentDTO);
        toSave.setUuid(id);

        return DEPARTMENT_MAPPER.entityToDto(departmentRepository.save(toSave));
    }

    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> listDepartments() {
        return departmentRepository.findAll().stream().map(DEPARTMENT_MAPPER::entityToDto).toList();
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        val byDepartmentCode = departmentRepository.findByDepartmentCode(code);
        return DEPARTMENT_MAPPER.entityToDto(byDepartmentCode.get());
    }
}
