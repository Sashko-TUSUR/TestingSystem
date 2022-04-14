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

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_group;

    private Long numGroup;

    public Long getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(Long numGroup) {
        this.numGroup = numGroup;
    }
}
