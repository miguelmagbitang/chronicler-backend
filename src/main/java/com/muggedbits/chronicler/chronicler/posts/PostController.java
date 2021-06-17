package com.muggedbits.chronicler.chronicler.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public ResponseEntity<Map<String, Object>> getPostByMoodAsc(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "3") int size) {
        Map<String, Object> response = postService.getPostsByMood(true, page, size);
        if (response.get("posts").equals(Collections.emptyList())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/mood-desc")
    public ResponseEntity<Map<String, Object>> getPostByMoodDesc(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "3") int size) {
        Map<String, Object> response = postService.getPostsByMood(false, page, size);
        if (response.get("posts").equals(Collections.emptyList())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/date-asc")
    public ResponseEntity<Map<String, Object>> getPostByDateAsc(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "3") int size) {
        Map<String, Object> response = postService.getPostsByDate(true, page, size);
        if (response.get("posts").equals(Collections.emptyList())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/date-desc")
    public ResponseEntity<Map<String, Object>> getPostByDateDesc(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "3") int size) {
        Map<String, Object> response = postService.getPostsByDate(false, page, size);
        if (response.get("posts").equals(Collections.emptyList())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
        return getPostByDateDesc(page, size);
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
