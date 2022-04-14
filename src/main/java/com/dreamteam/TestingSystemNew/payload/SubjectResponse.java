package com.dreamteam.TestingSystemNew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {
    Long id;
    String name;
    List<TopicResponse> topics;

}
