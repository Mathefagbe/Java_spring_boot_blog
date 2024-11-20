package com.apostle.blogging_platform_api.controllers;

import com.apostle.blogging_platform_api.Dto.PostRequest;
import com.apostle.blogging_platform_api.model.Post;
import com.apostle.blogging_platform_api.services.PostService;
import com.apostle.blogging_platform_api.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class PostController {

    private  final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public ResponseEntity<ApiResponse> getAllPosts(){
        ApiResponse apiResponse= new ApiResponse(
                "Post fetched successfully",
                postService.getAllPost(),
                "success"
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<ApiResponse> getPosts(@RequestBody PostRequest post){
        ApiResponse apiResponse= new ApiResponse(
                "Post save successfully",
                postService.savePost(post),
                "success"
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/post/{post_id}")
    public ResponseEntity<ApiResponse> getPostById(@PathVariable UUID post_id){
        ApiResponse apiResponse= new ApiResponse(
            "Post save successfully",
            postService.getPostById(post_id),
            "success"
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/post/{post_id}")
    public ResponseEntity<ApiResponse> updatePost(@PathVariable UUID post_id,@RequestBody PostRequest post){
        ApiResponse apiResponse= new ApiResponse(
                "Post updated successfully",
                postService.updatePost(post_id,post),
                "success"
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/post/{post_id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable UUID post_id){
        postService.deletePost(post_id);
        ApiResponse apiResponse= new ApiResponse(
                "Post Delete successfully",
                null,
                "success"
        );
        return ResponseEntity.ok().body(apiResponse);
    }
}