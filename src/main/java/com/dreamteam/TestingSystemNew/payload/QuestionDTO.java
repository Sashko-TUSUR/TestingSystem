package com.dreamteam.TestingSystemNew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private String question;
    private String image;
    private String trueAnswer;
}
