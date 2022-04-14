package com.dreamteam.TestingSystemNew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexityRequest {
    Long userId;
    Long topicId;
    int indexComplexity;
}
