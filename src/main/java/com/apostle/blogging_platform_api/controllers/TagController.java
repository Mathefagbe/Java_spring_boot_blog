package com.apostle.blogging_platform_api.controllers;


import com.apostle.blogging_platform_api.model.Tag;
import com.apostle.blogging_platform_api.services.TagService;
import com.apostle.blogging_platform_api.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tag")
    public ResponseEntity<ApiResponse> getTags(){
        ApiResponse apiResponse= new ApiResponse(
                "tags fetched successfully",
                tagService.getTags(),
                "success"
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/tag")
    public ResponseEntity<ApiResponse> saveTags(@Valid @RequestBody Tag tag){
        ApiResponse apiResponse= new ApiResponse(
                "tags fetched successfully",
                tagService.saveTags(tag),
                "success"
        );
        return ResponseEntity.ok().body(apiResponse);
    }
}
