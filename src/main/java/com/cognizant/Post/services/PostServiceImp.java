package com.cognizant.Post.services;

import com.cognizant.Post.model.PageOfItems;
import com.cognizant.Post.model.Post;
import com.cognizant.Post.model.PostDTO;
import com.cognizant.Post.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public PageOfItems<Post> getPosts(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());

        Page<Post> posts = postRepo.findAll(pageable);

        if(posts.hasContent()) {
            return new PageOfItems<Post>(posts.getContent(), posts.hasNext(), (int)posts.getTotalElements());
        }
        return new PageOfItems<Post>();
    }

    @Override
    public Post createPost(int userId, PostDTO postDTO) {
        Post post = new Post(
            0,
            userId,
            postDTO.getImg(),
            postDTO.getDescription(),
            LocalDate.now()
        );

        return postRepo.save(post);
    }

    public Boolean deletePost(int postId) {
        postRepo.deleteById(postId);

        return !postRepo.findById(postId).isPresent();
    }
}
