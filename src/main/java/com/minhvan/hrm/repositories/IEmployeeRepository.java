package com.minhvan.hrm.repositories;

import com.minhvan.hrm.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
