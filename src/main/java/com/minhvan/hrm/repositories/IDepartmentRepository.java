package com.minhvan.hrm.repositories;

import com.minhvan.hrm.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
}
