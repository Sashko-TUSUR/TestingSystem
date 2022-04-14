package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Group;
import com.dreamteam.TestingSystemNew.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group getByName(String Name);
}
