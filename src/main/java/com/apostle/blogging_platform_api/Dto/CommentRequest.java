package com.apostle.blogging_platform_api.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequest {
    private String body;
    private UUID post;
}
