package com.vijaykumar.backendapi.model;

import jakarta.validation.constraints.NotBlank;

public class PostRequest {

    @NotBlank(message = "Content must not be empty")
    private String content;

    public PostRequest() {
    }

    public PostRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}