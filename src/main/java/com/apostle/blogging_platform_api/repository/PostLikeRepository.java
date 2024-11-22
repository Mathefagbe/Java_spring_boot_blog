package com.apostle.blogging_platform_api.repository;
import com.apostle.blogging_platform_api.model.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLikes, UUID> {

}
