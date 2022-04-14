package com.dreamteam.TestingSystemNew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRequest {
    Long userId;
    Long topicId;
    Map<String, String> stringMap;
    DateTime openingTime;
    DateTime closingTime;

}
