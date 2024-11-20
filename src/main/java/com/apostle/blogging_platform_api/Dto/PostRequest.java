package com.apostle.blogging_platform_api.Dto;

import com.apostle.blogging_platform_api.model.Comment;
import com.apostle.blogging_platform_api.model.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PostRequest {
    private String title;
    private String body;
    private List<UUID> tags;
}
