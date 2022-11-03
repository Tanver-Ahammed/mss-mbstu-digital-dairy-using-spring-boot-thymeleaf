package com.mbstu.dairy.repositories;

import com.mbstu.dairy.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
