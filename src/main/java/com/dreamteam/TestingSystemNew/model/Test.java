package com.dreamteam.TestingSystemNew.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_user;
    private String id_topic;
    private Date closingDate;
    private String complexity;
    private String result;
    private Date openingDate;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_topic")
    private Topic topic;


}
