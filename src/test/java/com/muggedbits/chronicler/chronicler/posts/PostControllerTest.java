package com.muggedbits.chronicler.chronicler.posts;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostControllerTest {

    @Autowired
    private PostController postController;

    @MockBean
    private PostService postService;

    private List<Post> posts = Stream.of(new Post("title 1", LocalDate.of(1970, 1, 3), 10, "sample"),
            new Post("title 2", LocalDate.of(1970, 1, 2), 10, "sample"),
            new Post("title 3", LocalDate.of(1970, 1, 1), 10, "sample"))
            .collect(Collectors.toList());

//    @Test
//    void getPostCountTest() {
//        Mockito.when(postService.getPostCount()).thenReturn(2);
//        ResponseEntity response = postController.getPostCount();
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//    }
//
//    @Test
//    void getPostByMoodAscTest() {
//        Mockito.when(postService.getPostsByMood(true)).thenReturn(posts);
//        ResponseEntity response = postController.getPostByMoodAsc();
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody(), posts);
//    }
//
//    @Test
//    void getPostByMoodAscTest_noResults() {
//        Mockito.when(postService.getPostsByMood(true)).thenReturn(Collections.emptyList());
//        ResponseEntity response = postController.getPostByMoodAsc();
//        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
//        assertEquals(response.getBody(), null);
//    }
//
//    @Test
//    void getPostByMoodDescTest() {
//        Mockito.when(postService.getPostsByMood(false)).thenReturn(posts);
//        ResponseEntity response = postController.getPostByMoodDesc();
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody(), posts);
//    }
//
//    @Test
//    void getPostByMoodDescTest_noResults() {
//        Mockito.when(postService.getPostsByMood(false)).thenReturn(Collections.emptyList());
//        ResponseEntity response = postController.getPostByMoodAsc();
//        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
//        assertEquals(response.getBody(), null);
//    }
//
//    @Test
//    void getPostByDateAscTest() {
//        Mockito.when(postService.getPostsByDate(true)).thenReturn(posts);
//        ResponseEntity response = postController.getPostByDateAsc();
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody(), posts);
//    }
//
//    @Test
//    void getPostByDateAscTest_noResults() {
//        Mockito.when(postService.getPostsByMood(false)).thenReturn(Collections.emptyList());
//        ResponseEntity response = postController.getPostByMoodAsc();
//        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
//        assertEquals(response.getBody(), null);
//    }
//
//    @Test
//    void getAllPostsTest() {
//        Mockito.when(postService.getPostsByDate(false)).thenReturn(posts);
//        ResponseEntity response = postController.getAllPosts();
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody(), posts);
//    }
//
//    @Test
//    void getAllPostsNoResultTest() {
//        Mockito.when(postService.getPostsByDate(false)).thenReturn(Collections.emptyList());
//        ResponseEntity response = postController.getAllPosts();
//        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
//        assertEquals(response.getBody(), null);
//    }
//
//    @Test
//    void getPostByIdTest() {
//        Mockito.when(postService.getPostById(1)).thenReturn(Optional.of(posts.get(0)));
//        ResponseEntity response = postController.getPostById(1);
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody(), posts.get(0));
//    }
//
//    @Test
//    void getPostByIdTest_noResult() {
//        Mockito.when(postService.getPostById(1)).thenReturn(Optional.empty());
//        ResponseEntity response = postController.getPostById(1);
//        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
//        assertEquals(response.getBody(), null);
//    }
//
//    @Disabled
//    @Test
//    void createPostTest() {
//        PostWrapper postWrapper = new PostWrapper("title 1", "2021-06-01", 10, "sample");
//        Mockito.when(postService.createPost(postWrapper.asPost())).thenReturn(postWrapper.asPost());
//        ResponseEntity response = postController.createPost(postWrapper);
//        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
//        assertEquals(response.getBody(), posts.get(0));
//    }
//
//    @Test
//    void updatePost() {
//    }
//
//    @Test
//    void deletePost() {
//    }
//
//    @Test
//    void deleteAllPosts() {
//    }
}