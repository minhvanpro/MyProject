package com.minhvan.hrm.services.impl;

import com.minhvan.hrm.converter.ProjectConverter;
import com.minhvan.hrm.dtos.ProjectDto;
import com.minhvan.hrm.entities.Employee;
import com.minhvan.hrm.entities.Project;
import com.minhvan.hrm.repositories.IEmployeeRepository;
import com.minhvan.hrm.repositories.IProjectRepository;
import com.minhvan.hrm.services.IProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository iProjectRepository;

    @Autowired
    private ProjectConverter projectConverter;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public ProjectDto create(Project entity) {
        if (entity.getEmployees() != null) {
            for (int i = 0; i < entity.getEmployees().size(); i++) {
                Employee employee = entity.getEmployees().get(i);
                //System.out.println(employee.getId());
                Employee employeeId = iEmployeeRepository.findById(employee.getId()).get();
                if (employeeId != null) {
                    entity.getEmployees().set(i, employeeId);
                }
            }
        }
        entity = iProjectRepository.save(entity);
        ProjectDto result = projectConverter.toDto(entity);
        return result;
    }

    @Override
    public Boolean removeById(Long id) {
        try {
            iProjectRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public ProjectDto update(Project entity) {
        Optional<Project> optionalProject = iProjectRepository.findById(entity.getId());
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setName(entity.getName());
            project = iProjectRepository.save(project);
            ProjectDto result = projectConverter.toDto(project);
            return result;
        }
        return null;
    }

    @Override
    public List<ProjectDto> getAll() {
        List<Project> listProjectEntity = iProjectRepository.findAll();
        List<ProjectDto> listProjectDto = new ArrayList<>();
        if (!listProjectEntity.isEmpty()) {
            for (int i = 0; i < listProjectEntity.size(); i++) {
                listProjectDto.add(projectConverter.toDto(listProjectEntity.get(i)));
            }
            return listProjectDto;
        }
        return null;
    }
}
