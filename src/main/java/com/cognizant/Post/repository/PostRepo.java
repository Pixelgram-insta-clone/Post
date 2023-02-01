package com.cognizant.Post.repository;

import com.cognizant.Post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;


@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{

    /**
     * Return a page of Post entities.
     *
     * @param pageable
     * @return
     */
    Page<Post> findAll(Pageable pageable);
}
