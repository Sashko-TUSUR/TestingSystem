package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject getByName(String name);
    Subject getBySubjectId(Long id);
}
