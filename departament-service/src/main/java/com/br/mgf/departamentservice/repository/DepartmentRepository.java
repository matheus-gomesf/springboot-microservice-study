package com.br.mgf.departamentservice.repository;

import com.br.mgf.departamentservice.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, UUID> {
}
