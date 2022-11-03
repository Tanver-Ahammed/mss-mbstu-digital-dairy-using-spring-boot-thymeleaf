package com.mbstu.dairy.repositories;

import com.mbstu.dairy.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
