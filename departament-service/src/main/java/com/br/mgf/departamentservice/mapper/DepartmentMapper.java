package com.br.mgf.departamentservice.mapper;

import com.br.mgf.departamentservice.entity.DepartmentEntity;
import com.br.mgf.departamentservice.entity.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper DEPARTMENT_MAPPER = Mappers.getMapper(DepartmentMapper.class);

    DepartmentEntity dtoToEntity(DepartmentDTO record);

    DepartmentDTO entityToDto(DepartmentEntity entity);
}
