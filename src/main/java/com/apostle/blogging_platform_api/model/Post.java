package com.apostle.blogging_platform_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,length = 500)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "post")
//    @JsonIgnore
    private List<Comment> comments;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "post_tags", // Custom join table name
            joinColumns = @JoinColumn(name = "post_id"), // Join column for Post
            inverseJoinColumns = @JoinColumn(name = "tag_id") // Join column for Tag
    )
//    @JsonManagedReference
    private List<Tag> tags;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
