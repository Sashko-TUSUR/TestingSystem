package com.dreamteam.TestingSystemNew.controller;

import com.dreamteam.TestingSystemNew.payload.QuestionDTO;
import com.dreamteam.TestingSystemNew.payload.SubjectResponse;
import com.dreamteam.TestingSystemNew.payload.UserProfile;
import com.dreamteam.TestingSystemNew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_STUDENT')")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    UserService userService;

    @GetMapping("/topics")
    public List<SubjectResponse> getSubjectsAndTopics(@RequestParam(value = "id") Long id){
        return userService.getSubjectsAndTopics(id);
    }

    @GetMapping("/option")
    public ArrayList<QuestionDTO> getOption(@RequestParam(value = "user_id") Long userId, @RequestParam(value = "topic_id") Long topicId){
        return userService.getOption(userId, topicId);
    }

    @GetMapping("/user")
    public UserProfile getUser(@RequestParam(value = "id") Long userId){
        return userService.getUser(userId);
    }
}
