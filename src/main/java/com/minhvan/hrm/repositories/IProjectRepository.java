package com.minhvan.hrm.repositories;

import com.minhvan.hrm.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Long> {
}
