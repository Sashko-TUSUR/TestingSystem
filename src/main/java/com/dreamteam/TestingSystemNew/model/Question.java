package com.dreamteam.TestingSystemNew.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_question;

    private String questionJSON;

    @ManyToOne(cascade = CascadeType.ALL)
    private Complexity complexity;

    @ManyToOne
    @JoinColumn(name = "id_topic")
    private Topic topic;

    public int getId() {
        return id_question;
    }

    public void setId(int id) {
        this.id_question = id;
    }

    public Question(String questionJSON, Complexity complexity, Topic topic) {
        this.questionJSON = questionJSON;
        this.complexity = complexity;
        this.topic = topic;
    }
}
