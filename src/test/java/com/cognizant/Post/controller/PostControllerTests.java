package com.cognizant.Post.controller;

import com.cognizant.Post.model.PageOfItems;
import com.cognizant.Post.model.Post;
import com.cognizant.Post.model.PostDTO;
import com.cognizant.Post.services.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostControllerTests {

    private static LocalDate date;
    private static Post post;
    private static PostDTO postDTO;

    private static PageOfItems<Post> pageOfItems;
    private static List<Post> posts;

    @Mock
    PostService service;

    @InjectMocks
    PostController controller;

    @BeforeAll
    public static void init() {
        pageOfItems = new PageOfItems<>();
        posts = new ArrayList<>();
        date = LocalDate.now();

        for(int i = 0; i < 5; i ++) {
            posts.add(post);
        }
        pageOfItems.setItems(posts);

        post = new Post(
                1,
                1,
                "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2021%2F07%2F13%2FUltimate-Veggie-Burgers-FT-Recipe-0821.jpg&q=60", "Food at McDonalds was great!",
                date
        );
        postDTO = new PostDTO(
                post.getImg(),
                post.getDescription()
        );
    }

    @Test
    void getPosts(){
        when(service.getPosts(0, 5)).thenReturn(pageOfItems);
        PageOfItems<Post> actual = controller.getPosts(0, 5);
        Assertions.assertEquals(pageOfItems,actual);
    }

    @Test
    void addPost() {

        when(service.createPost(post.getId(), postDTO)).thenReturn(post);

        Post actual = controller.addPost(post.getUserId(), postDTO);

        assertEquals(post, actual);
    }

    @Test
    void deletePost_positive() {
        when(service.deletePost(1)).thenReturn(true);
        Boolean actual = controller.deletePost(1);
        Assertions.assertEquals(actual, true);
    }

}
