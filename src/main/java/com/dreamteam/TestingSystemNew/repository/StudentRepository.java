package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
