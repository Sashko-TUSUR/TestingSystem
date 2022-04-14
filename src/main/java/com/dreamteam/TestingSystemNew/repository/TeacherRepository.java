package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
