package com.br.mgf.employeeservice.mapper;

import com.br.mgf.employeeservice.entity.EmployeeEntity;
import com.br.mgf.employeeservice.entity.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeEntity dtoToEntity(EmployeeDTO record);

    EmployeeDTO entityToDto(EmployeeEntity entity);
}
