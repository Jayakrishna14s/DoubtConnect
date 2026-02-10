package com.app.doubtconnect.dto;

import com.app.doubtconnect.model.Answer;
import com.app.doubtconnect.model.Doubt;
import com.app.doubtconnect.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DoubtResponse {

    private Long id;
    private String title;
    private String description;
    private User user;
    private List<Answer> answers;

    public static DoubtResponse from(Doubt doubt) {
        return DoubtResponse.builder()
                .id(doubt.getDoubtId())
                .title(doubt.getTitle())
                .description(doubt.getDescription())
                .user(doubt.getUser())
                .answers(doubt.getAnswers())
                .build();
    }
}
