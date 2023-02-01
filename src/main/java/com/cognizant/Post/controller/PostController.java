package com.cognizant.Post.controller;

import com.cognizant.Post.model.PageOfItems;
import com.cognizant.Post.model.Post;
import com.cognizant.Post.model.PostDTO;
import com.cognizant.Post.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostService service;

    @GetMapping("/posts")
    PageOfItems<Post> getPosts(@RequestParam int pageNumber, @RequestParam int pageSize){
        return service.getPosts(pageNumber, pageSize);
    }

    @PostMapping("/users/{userId}/posts")
    Post addPost(
        @PathVariable int userId,
        @RequestBody PostDTO postDTO
    ) {
        return service.createPost(userId, postDTO);
    }

    @DeleteMapping("/posts")
    Boolean deletePost(
            @RequestParam int postId
    ) {
        return service.deletePost(postId);
    }

}
