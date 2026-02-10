package com.app.doubtconnect.dto;

public class AnswerDTO {
    private String content;

    public AnswerDTO() {
    }

    public AnswerDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AnswerDTO [content=" + content + "]";
    }
}
