package com.apostle.blogging_platform_api.services;

import com.apostle.blogging_platform_api.Dto.PostRequestDTO;
import com.apostle.blogging_platform_api.enums.PostStatus;
import com.apostle.blogging_platform_api.exceptions.NotFoundException;
import com.apostle.blogging_platform_api.model.Post;
import com.apostle.blogging_platform_api.model.Tag;
import com.apostle.blogging_platform_api.repository.PostRepository;
import com.apostle.blogging_platform_api.repository.TagRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private  final TagRepository tagRepository;

    public PostService(PostRepository postRepository,TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository=tagRepository;
    }

    public List<Post> getAllPost(String searchText){
        if (searchText != null){
            return postRepository.searchPostByTitleOrBody(searchText);
        }
        //to be optimized
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .sorted((p1,p2)-> Integer.compare(p2.getlikeCount(), p1.getlikeCount())).toList();
    }

    public Post savePost(PostRequestDTO postRequestDTO){
        Post post =new Post();
        post.setBody(postRequestDTO.getBody());
        post.setTitle(postRequestDTO.getTitle());
        post.setPostStatus(Objects.equals(postRequestDTO.getPostStatus(), "DRAFT") ?PostStatus.DRAFT :PostStatus.PUBLISH);
        List<Tag>tags=tagRepository.findAllById(postRequestDTO.getTags());
        post.setTags(tags);
        return postRepository.save(post);
    }

    public Post getPostById(UUID postId){
        return postRepository.findById(postId)
                .orElseThrow(()->new NotFoundException("Post Not Found with this id"+postId));
    }

    public Post updatePost(UUID postId, PostRequestDTO postRequestDTO) {
        Post post =postRepository.findById(postId)
                .orElseThrow(()->new NotFoundException("Post Not Found with this id"+postId));
        post.setBody(postRequestDTO.getBody());
        post.setTitle(postRequestDTO.getTitle());
        post.setPostStatus(Objects.equals(postRequestDTO.getPostStatus(), "DRAFT")
                ? PostStatus.DRAFT :PostStatus.PUBLISH);
        List<Tag>tags=tagRepository.findAllById(postRequestDTO.getTags());
        post.setTags(tags);
        return postRepository.save(post);

    }

    public void deletePost(UUID postId) {
        postRepository.deleteById(postId);
    }

}
