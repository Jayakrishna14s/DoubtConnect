package com.app.doubtconnect.dto;

import com.app.doubtconnect.model.Answer;
import com.app.doubtconnect.model.Doubt;
import com.app.doubtconnect.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AnswerResponse {
    private Long answerId;
    private String content;
    private Doubt doubt;
    private User user;

    public AnswerResponse() {
    }

    public static AnswerResponse from(Answer answer) {
        return new AnswerResponse(answer.getAnswerId(), answer.getContent(), answer.getDoubt(), answer.getUser());
    }
}


