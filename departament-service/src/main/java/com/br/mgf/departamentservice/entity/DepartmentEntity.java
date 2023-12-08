package com.br.mgf.departamentservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "DEPARTMENT_DESCRIPTION")
    private String departmentDescription;
    @Column(name = "DEPARTMENT_CODE")
    private String departmentCode;
}
