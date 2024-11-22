package com.apostle.blogging_platform_api.repository;

import com.apostle.blogging_platform_api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByOrderByCreatedAtDesc();
    //select from the table where like
    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "OR LOWER(p.body) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Post> searchPostByTitleOrBody(@Param("searchText") String searchText);
}
