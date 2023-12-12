package com.br.mgf.employeeservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartmentDTO {

    private UUID uuid;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
