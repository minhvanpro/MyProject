package com.minhvan.hrm.services;

import com.minhvan.hrm.dtos.ProjectDto;
import com.minhvan.hrm.entities.Project;

import java.util.List;

public interface IProjectService {
    ProjectDto create(Project entity);

    Boolean removeById(Long id);

    ProjectDto update(Project entity);

    List<ProjectDto> getAll();
}
