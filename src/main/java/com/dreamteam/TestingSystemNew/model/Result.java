package com.dreamteam.TestingSystemNew.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_user;
    private String name;
    private String topic;
    private Long result;
    private String date;

    @OneToMany
    @JoinColumn(name = "result")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
