package com.cognizant.Post.services;

import com.cognizant.Post.model.PageOfItems;
import com.cognizant.Post.model.Post;
import com.cognizant.Post.model.PostDTO;
import com.cognizant.Post.repository.PostRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepo postRepo;

    @Mock
    private Page<Post> page;

    @InjectMocks
    private PostServiceImp postServiceImp;

    private static Post post;
    private static PostDTO postDTO;
    private static LocalDate date;

    @BeforeAll
    public static void init() {
        date = LocalDate.now();

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
    void getPosts_positive() {

        Pageable fakePageable = PageRequest.of(1, 5, Sort.by("id").descending());

        List<Post> fakePosts = new ArrayList<>();
        fakePosts.add(post);
        fakePosts.add(post);
        fakePosts.add(post);
        fakePosts.add(post);
        fakePosts.add(post);

        when(postRepo.findAll(fakePageable)).thenReturn(page);

        when(page.hasContent()).thenReturn(true);
        when(page.getContent()).thenReturn(fakePosts);
        when(page.hasNext()).thenReturn(true);
        when(page.getTotalElements()).thenReturn(22l);

        PageOfItems<Post> expected = new PageOfItems<Post>(fakePosts, true, 22);
        Assertions.assertEquals(expected, postServiceImp.getPosts(1, 5));

    }

    @Test
    void getPosts_NoPosts() {

        Pageable fakePageable = PageRequest.of(1, 5, Sort.by("id").descending());

        when(postRepo.findAll(fakePageable)).thenReturn(page);

        when(page.hasContent()).thenReturn(false);

        PageOfItems<Post> expected = new PageOfItems<Post>();
        Assertions.assertEquals(expected, postServiceImp.getPosts(1, 5));

    }

    @Test
    void getPosts_lessThanFivePosts() {

        Pageable fakePageable = PageRequest.of(0, 5, Sort.by("id").descending());

        List<Post> fakePosts = new ArrayList<>();
        fakePosts.add(post);
        fakePosts.add(post);
        fakePosts.add(post);
        fakePosts.add(post);

        when(postRepo.findAll(fakePageable)).thenReturn(page);

        when(page.hasContent()).thenReturn(true);
        when(page.getContent()).thenReturn(fakePosts);
        when(page.hasNext()).thenReturn(false);
        when(page.getTotalElements()).thenReturn(4l);

        PageOfItems<Post> expected = new PageOfItems<Post>(fakePosts, false, 4);
        Assertions.assertEquals(expected, postServiceImp.getPosts(0, 5));

    }

    @Test
    void createPost_positive() {

        Post postToSave = new Post(
                0,
                post.getUserId(),
                post.getImg(),
                post.getDescription(),
                post.getCreatedOn()
        );

        when(postRepo.save(postToSave)).thenReturn(post);

        Post actual = postServiceImp.createPost(post.getUserId(), postDTO);

        assertEquals(post, actual);
    }

    @Test
    void deletePost_positiveTest() {
        when(postRepo.findById(0)).thenReturn(Optional.empty());
        Boolean actual = postServiceImp.deletePost(0);
        Assertions.assertEquals(actual, true);
    }

    @Test
    void deletePost_negativeTest() {
        when(postRepo.findById(0)).thenReturn(Optional.of(post));
        Boolean actual = postServiceImp.deletePost(0);
        Assertions.assertEquals(actual, false);
    }
}
