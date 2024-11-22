package com.apostle.blogging_platform_api.controllers;

import com.apostle.blogging_platform_api.Dto.PostRequestDTO;
import com.apostle.blogging_platform_api.services.PostService;
import com.apostle.blogging_platform_api.utils.ApiResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1")
public class PostController {

    private  final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public ResponseEntity<ApiResponse> getAllPosts(@PathParam("searchText") String searchText){
        ApiResponse apiResponse= new ApiResponse(
                "Post fetched successfully",
                postService.getAllPost(searchText),
                "success"
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/post")
    public ResponseEntity<ApiResponse> getPosts(@Valid @RequestBody PostRequestDTO post){
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
            "Post fetched successfully",
            postService.getPostById(post_id),
            "success"
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/post/{post_id}")
    public ResponseEntity<ApiResponse> updatePost(@PathVariable UUID post_id,@Valid @RequestBody PostRequestDTO post){
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
