package com.apostle.blogging_platform_api.services;

import com.apostle.blogging_platform_api.Dto.CommentRequestDTO;
import com.apostle.blogging_platform_api.exceptions.NotFoundException;
import com.apostle.blogging_platform_api.model.Comment;
import com.apostle.blogging_platform_api.model.Post;
import com.apostle.blogging_platform_api.repository.CommentRespository;
import com.apostle.blogging_platform_api.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private final CommentRespository commentRespository;
    private  final PostRepository postRepository;

    public CommentService(CommentRespository commentRespository,PostRepository postRepository) {
        this.commentRespository = commentRespository;
        this.postRepository=postRepository;
    }

    public Comment saveComment( CommentRequestDTO commentRequestDTO){
        Comment comment =new Comment();
        comment.setBody(commentRequestDTO.getBody());
        Post post=postRepository.findById(commentRequestDTO.getPost()).orElseThrow(()->
                new NotFoundException("Post with this id doesn't exist"));
        comment.setPost(post);
        return commentRespository.save(comment);
    }

    public List<Comment> getComment(UUID postId) {
        if (postId == null)
            return commentRespository.findAll();
        return commentRespository.findCommentByPostId(postId);
    }

    public void deleteComment(UUID commentId) {
        commentRespository.deleteById(commentId);
    }

    public Comment updateComment(UUID commentId, CommentRequestDTO commentRequestDTO){
        Comment comment =commentRespository.findById(commentId).orElseThrow(()->
                new NotFoundException("Comment with this id not found"+commentId));
        comment.setBody(commentRequestDTO.getBody());
        Post post=postRepository.findById(commentRequestDTO.getPost()).orElseThrow(()->
                new NotFoundException("Post with this id doesn't exist id"+ commentRequestDTO.getPost()));
        comment.setPost(post);
        return commentRespository.save(comment);
    }
}
