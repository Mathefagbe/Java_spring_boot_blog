package com.apostle.blogging_platform_api.services;

import com.apostle.blogging_platform_api.exceptions.NotFoundException;
import com.apostle.blogging_platform_api.model.Post;
import com.apostle.blogging_platform_api.model.PostLikes;
import com.apostle.blogging_platform_api.repository.PostLikeRepository;
import com.apostle.blogging_platform_api.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostLikeService {
    private  final PostLikeRepository postLikeRepository;
    private  final PostRepository postRepository;

    public PostLikeService(PostLikeRepository postLikeRepository,
                           PostRepository postRepository) {
        this.postLikeRepository = postLikeRepository;
        this.postRepository=postRepository;
    }

    public void upVotePost(UUID post_id){
        PostLikes postLikes=new PostLikes();
        Post post=postRepository.findById(post_id).orElseThrow(()->
                new NotFoundException("post with this id"+post_id +"doesnt exist"));
        postLikes.setPost(post);
        postLikeRepository.save(postLikes);
    }
}
