package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Complexity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComplexityRepository extends JpaRepository<Complexity, Long> {
}
