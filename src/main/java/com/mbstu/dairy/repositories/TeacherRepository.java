package com.mbstu.dairy.repositories;

import com.mbstu.dairy.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
