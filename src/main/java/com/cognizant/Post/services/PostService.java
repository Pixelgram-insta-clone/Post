package com.cognizant.Post.services;

import com.cognizant.Post.model.PageOfItems;
import com.cognizant.Post.model.Post;
import com.cognizant.Post.model.PostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    PageOfItems<Post> getPosts(int pageNumber, int pageSize);

    Post createPost(int userId, PostDTO postDTO);
    Boolean deletePost(int postId);
}
