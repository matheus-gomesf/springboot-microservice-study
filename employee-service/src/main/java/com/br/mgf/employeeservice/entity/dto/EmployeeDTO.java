package com.br.mgf.employeeservice.entity.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDTO {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
}
