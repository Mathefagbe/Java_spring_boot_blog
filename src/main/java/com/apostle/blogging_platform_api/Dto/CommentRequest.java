package com.apostle.blogging_platform_api.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequest {
    @NotNull(message = "Body Field Cannot be null")
    @NotBlank(message = "Body Field Cannot be Blank")
    private String body;
    @NotNull(message = "Post Field Cannot be null")
    @NotBlank(message = "Post Field Cannot be Blank")
    private UUID post;
}
