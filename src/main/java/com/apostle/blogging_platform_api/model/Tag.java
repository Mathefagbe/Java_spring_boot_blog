package com.apostle.blogging_platform_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String tag;
    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Post> post;

}
