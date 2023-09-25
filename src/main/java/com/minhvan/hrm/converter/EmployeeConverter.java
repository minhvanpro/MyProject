package com.minhvan.hrm.converter;

import com.minhvan.hrm.dtos.EmployeeDto;
import com.minhvan.hrm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private DepartmentConverter departmentConverter;

    public Employee toEntity(EmployeeDto dto) {
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setFullName(dto.getFullName());
        entity.setIdAddress(addressConverter.toEntity(dto.getIdAddress()));
        entity.setIdDepartment(departmentConverter.toEntity(dto.getIdDepartment()));
        return entity;
    }

    public EmployeeDto toDto(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setIdAddress(addressConverter.toDto(entity.getIdAddress()));
        dto.setIdDepartment(departmentConverter.toDto(entity.getIdDepartment()));
        return dto;
    }
}
