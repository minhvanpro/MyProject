package com.minhvan.hrm.converter;

import com.minhvan.hrm.dtos.DepartmentDto;
import com.minhvan.hrm.entities.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {
    public Department toEntity(DepartmentDto dto) {
        Department entity = new Department();
        entity.setName(dto.getName());
        entity.setId(entity.getId());
        return entity;
    }

    public DepartmentDto toDto(Department entity) {
        DepartmentDto dto = new DepartmentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
