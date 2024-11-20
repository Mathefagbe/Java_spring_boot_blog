package com.apostle.blogging_platform_api.services;

import com.apostle.blogging_platform_api.Dto.PostRequest;
import com.apostle.blogging_platform_api.exceptions.NotFoundException;
import com.apostle.blogging_platform_api.model.Post;
import com.apostle.blogging_platform_api.model.Tag;
import com.apostle.blogging_platform_api.repository.PostRepository;
import com.apostle.blogging_platform_api.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private  final TagRepository tagRepository;

    public PostService(PostRepository postRepository,TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository=tagRepository;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post savePost(PostRequest postRequest){
        Post post =new Post();
        post.setBody(postRequest.getBody());
        post.setTitle(postRequest.getTitle());
        List<Tag>tags=tagRepository.findAllById(postRequest.getTags());
        post.setTags(tags);
        return postRepository.save(post);
    }

    public Post getPostById(UUID postId){
        return postRepository.findById(postId)
                .orElseThrow(()->new NotFoundException("Post Not Found with this id"+postId));
    }

    public Post updatePost(UUID postId, PostRequest postRequest) {
        Post post =postRepository.findById(postId)
                .orElseThrow(()->new NotFoundException("Post Not Found with this id"+postId));
        post.setBody(postRequest.getBody());
        post.setTitle(postRequest.getTitle());
        List<Tag>tags=tagRepository.findAllById(postRequest.getTags());
        post.setTags(tags);
        return postRepository.save(post);

    }

    public void deletePost(UUID postId) {
        postRepository.deleteById(postId);
    }
}
