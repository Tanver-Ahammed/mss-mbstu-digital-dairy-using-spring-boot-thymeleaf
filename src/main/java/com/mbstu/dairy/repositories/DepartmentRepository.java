package com.mbstu.dairy.repositories;

import com.mbstu.dairy.entities.Department;
import com.mbstu.dairy.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findDepartmentByFaculty(Faculty faculty);

}
