package com.minhvan.hrm.services;

import com.minhvan.hrm.dtos.DepartmentDto;
import com.minhvan.hrm.entities.Department;

import java.util.List;

public interface IDepartmentService {
    DepartmentDto create(Department entity);

    List<DepartmentDto> getAll();

    Boolean removeById(Long id);

    DepartmentDto update(Department entity);
}
