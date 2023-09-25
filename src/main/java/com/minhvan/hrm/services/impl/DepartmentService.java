package com.minhvan.hrm.services.impl;

import com.minhvan.hrm.converter.DepartmentConverter;
import com.minhvan.hrm.dtos.DepartmentDto;
import com.minhvan.hrm.entities.Department;
import com.minhvan.hrm.entities.Employee;
import com.minhvan.hrm.repositories.IDepartmentRepository;
import com.minhvan.hrm.services.IDepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @Autowired
    private DepartmentConverter departmentConverter;

    @Override
    public DepartmentDto create(Department entity) {
        if (entity.getEmployees() != null) {
            for (int i = 0; i < entity.getEmployees().size(); i++) {
                Employee employee = entity.getEmployees().get(i);
                employee.setIdDepartment(entity);
            }
        }
        entity = iDepartmentRepository.save(entity);
        DepartmentDto result = departmentConverter.toDto(entity);
        return result;
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> listDepartmentEntity = iDepartmentRepository.findAll();
        List<DepartmentDto> listDepartmentDto = new ArrayList<>();
        if (!listDepartmentEntity.isEmpty()) {
            for (int i = 0; i < listDepartmentEntity.size(); i++) {
                listDepartmentDto.add(departmentConverter.toDto(listDepartmentEntity.get(i)));
            }
            return listDepartmentDto;
        }
        return null;
    }

    @Override
    public Boolean removeById(Long id) {
        try {
            iDepartmentRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public DepartmentDto update(Department entity) {
        Optional<Department> optionalDepartment = iDepartmentRepository.findById(entity.getId());
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(entity.getName());
            department = iDepartmentRepository.save(department);
            DepartmentDto result = departmentConverter.toDto(department);
            return result;
        }
        return null;
    }
}
