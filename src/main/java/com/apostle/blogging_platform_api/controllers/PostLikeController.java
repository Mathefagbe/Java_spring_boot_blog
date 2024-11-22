package com.apostle.blogging_platform_api.controllers;

import com.apostle.blogging_platform_api.services.PostLikeService;
import com.apostle.blogging_platform_api.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class PostLikeController {
    private final PostLikeService postLikeService;

    public PostLikeController(PostLikeService postLikeService) {
        this.postLikeService = postLikeService;
    }


    @PostMapping("post/{post_id}/upvote")
    public ResponseEntity<?> upVotePost(@PathVariable UUID post_id){
        postLikeService.upVotePost(post_id);
        ApiResponse apiResponse= new ApiResponse(
                "Post save successfully",
                null,
                "success"
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
