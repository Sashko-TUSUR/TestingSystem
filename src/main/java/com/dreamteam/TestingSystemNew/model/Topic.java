package com.dreamteam.TestingSystemNew.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_topic;

    private Long idDidacticUnit;
    private  String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_DidacticUnit")
    private DidacticUnit didacticUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
