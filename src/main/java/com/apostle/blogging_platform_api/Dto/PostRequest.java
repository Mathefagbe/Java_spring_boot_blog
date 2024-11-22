package com.apostle.blogging_platform_api.Dto;
import com.apostle.blogging_platform_api.enums.*;
import com.apostle.blogging_platform_api.validations.ValidPostStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PostRequest {
    @NotNull(message = "Title Field Cannot be null")
    @NotBlank(message = "Title Field Cannot be Blank")
    private String title;
    private String body;
    private List<UUID> tags;


    @NotNull(message = "Title Field Cannot be null")
    @ValidPostStatus()
    private String postStatus;
}
