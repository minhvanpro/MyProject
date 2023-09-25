package com.minhvan.hrm.services;

import com.minhvan.hrm.dtos.EmployeeDto;
import com.minhvan.hrm.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto create(Employee entity);

    Boolean removeById(Long id);

    List<EmployeeDto> getAll();

    EmployeeDto update(Employee entity);
}
