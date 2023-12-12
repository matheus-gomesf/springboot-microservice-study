package com.br.mgf.employeeservice.service;

import com.br.mgf.employeeservice.entity.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("departments/{code}")
    DepartmentDTO getDepartmentByCode(@PathVariable String code);
}
