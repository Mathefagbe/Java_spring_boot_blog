package com.apostle.blogging_platform_api.services;

import com.apostle.blogging_platform_api.model.Tag;
import com.apostle.blogging_platform_api.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public  TagService(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    public List<Tag> getTags(){
        return tagRepository.findAll();
    }

    public  Tag saveTags(Tag tag){
        return tagRepository.save(tag);
    }
}
