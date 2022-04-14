package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.DidacticUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DidacticUnitRepository extends JpaRepository<DidacticUnit , Long> {

}
