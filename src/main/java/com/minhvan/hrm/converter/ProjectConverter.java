package com.minhvan.hrm.converter;

import com.minhvan.hrm.dtos.ProjectDto;
import com.minhvan.hrm.entities.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter {
    public Project toEntity(ProjectDto dto) {
        Project entity = new Project();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public ProjectDto toDto(Project entity) {
        ProjectDto dto = new ProjectDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
