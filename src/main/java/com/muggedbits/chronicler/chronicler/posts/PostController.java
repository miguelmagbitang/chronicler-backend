package com.muggedbits.chronicler.chronicler.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/count")
    public ResponseEntity<Integer> getPostCount() {
        return new ResponseEntity<>(postService.getPostCount(), HttpStatus.OK);
    }

    @GetMapping("/mood-asc")
    public ResponseEntity<List<Post>> getPostByMoodAsc() {
        List<Post> posts = new ArrayList<>();
        posts = postService.getPostsByMood(true);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/mood-desc")
    public ResponseEntity<List<Post>> getPostByMoodDesc() {
        List<Post> posts = new ArrayList<>();
        posts = postService.getPostsByMood(false);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/date-asc")
    public ResponseEntity<List<Post>> getPostByDateAsc() {
        List<Post> posts = new ArrayList<>();
        posts = postService.getPostsByDate(true);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping("/date-desc")
    public ResponseEntity<List<Post>> getPostByDateDesc() {
        List<Post> posts = new ArrayList<>();
        posts = postService.getPostsByDate(false);
        System.out.println(posts);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPosts() {
        return getPostByDateDesc();
//        List<Post> posts = new ArrayList<>();
//        posts = postService.getAllPosts();
//        if (posts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(posts, HttpStatus.OK);
//        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            return new ResponseEntity<>(post.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody PostWrapper postWrapper) {
        try {
            Post postToBeSaved = postWrapper.asPost();
            Post postSaved = postService.createPost(postToBeSaved);
            return new ResponseEntity<>(postSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody PostWrapper postWrapper) {
        Post postToBeUpdated = postWrapper.asPost();
        Optional<Post> postUpdated = postService.updatePost(id, postToBeUpdated);
        if (postUpdated.isPresent()) {
            return new ResponseEntity<>(postUpdated.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllPosts() {
        postService.deleteAllPosts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
