package com.apostle.blogging_platform_api.controllers;

import com.apostle.blogging_platform_api.Dto.CommentRequestDTO;
import com.apostle.blogging_platform_api.services.CommentService;
import com.apostle.blogging_platform_api.utils.ApiResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class CommentController {

    private  final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<ApiResponse> saveComment(@Valid @RequestBody CommentRequestDTO comment){
        ApiResponse apiResponse= new ApiResponse(
                "Post save successfully",
                commentService.saveComment(comment),
                "success"
        );
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping("/comments")
    public ResponseEntity<ApiResponse> getComment(@PathParam("postId") UUID postId){
        try{
            ApiResponse apiResponse= new ApiResponse(
                    "Comment fetched successfully",
                    commentService.getComment(postId),
                    "success"
            );
            return ResponseEntity.ok().body(apiResponse);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable UUID commentId){
        commentService.deleteComment(commentId);
        ApiResponse apiResponse= new ApiResponse(
                "Comment fetched successfully",
                null,
                "success"
        );
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> updateComment(@PathVariable UUID commentId,@Valid @RequestBody CommentRequestDTO comment){
        ApiResponse apiResponse= new ApiResponse(
                "Post save successfully",
                commentService.updateComment(commentId,comment),
                "success"
        );
        return ResponseEntity.ok().body(apiResponse);
    }
}
