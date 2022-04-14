package com.dreamteam.TestingSystemNew.controller;

import com.dreamteam.TestingSystemNew.payload.*;
import com.dreamteam.TestingSystemNew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_TEACHER')")
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private UserService userService;

    @GetMapping("/subjects")
    public List<SubjectResponse> getSubjectsAndTopics(@RequestParam(value = "id") Long id){
        return userService.getSubjectsAndTopics(id);
    }

    @PostMapping("/question/add")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest questionRequest){
        userService.saveQuestion(questionRequest);
        return ResponseEntity.ok("Success add question!");
    }

    @PostMapping("/template/add")
    public ResponseEntity<?> addTemplate(@RequestBody TemplateRequest templateRequest){
        userService.saveTemplate(templateRequest);
        return ResponseEntity.ok("Success add template!");
    }

    @PostMapping("/complexity/add")
    public ResponseEntity<?> addComplexty(@RequestBody ComplexityRequest complexityRequest){
        userService.setComplexityForUser(complexityRequest);
        return ResponseEntity.ok("Success add complexity!");
    }

    @PostMapping("/topic/add")
    public ResponseEntity<?> addTopic(@RequestBody TopicRequest topicRequest){
        userService.saveTopic(topicRequest);
        return ResponseEntity.ok("Success add topic!");
    }

    @GetMapping("/user")
    public UserProfile getUser(@RequestParam(value = "id") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/group")
    public List<GroupResponse> getGroup(@RequestParam Long userId){
        return userService.getGroupForTeacher(userId);
    }



}
