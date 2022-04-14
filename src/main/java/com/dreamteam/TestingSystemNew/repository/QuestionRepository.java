package com.dreamteam.TestingSystemNew.repository;

import com.dreamteam.TestingSystemNew.model.Complexity;
import com.dreamteam.TestingSystemNew.model.Question;
import com.dreamteam.TestingSystemNew.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    ArrayList<Question> getByTopicAndComplexity(Topic topic, String complexity);
}
