package com.mbstu.dairy.repositories;

import com.mbstu.dairy.entities.Department;
import com.mbstu.dairy.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findTeacherByDepartment(Department department);

}
