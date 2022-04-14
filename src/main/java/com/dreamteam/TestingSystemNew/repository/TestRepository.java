package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
