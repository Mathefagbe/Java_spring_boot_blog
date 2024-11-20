package com.apostle.blogging_platform_api.repository;

import com.apostle.blogging_platform_api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRespository extends JpaRepository<Comment, UUID> {

    List<Comment> findByPostId(UUID postId);

}
