package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History,Long> {
    Optional<History> findByHistoryId(Long id);
}
