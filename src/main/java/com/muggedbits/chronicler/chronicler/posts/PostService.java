package com.muggedbits.chronicler.chronicler.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public int getPostCount() {
        return (int) postRepository.count();
    }

    public Map<String, Object> getPostsByTitle(String title, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Post> pagePosts = postRepository.findByTitleContaining(title, paging);
        Map<String, Object> response = constructMap(pagePosts);
        return response;
    }

    public Map<String, Object> getPostsByDate(boolean ascending, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Post> pagePosts = ascending ? postRepository.findAllByOrderByDateAsc(paging)
                : postRepository.findAllByOrderByDateDesc(paging);
        Map<String, Object> response = constructMap(pagePosts);
        return response;
    }

    public Map<String, Object> getPostsByMood(boolean ascending, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Post> pagePosts = ascending ? postRepository.findAllByOrderByMoodAsc(paging)
                : postRepository.findAllByOrderByMoodDesc(paging);
        Map<String, Object> response = constructMap(pagePosts);
        return response;
    }

    @Deprecated
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        Post postSaved = postRepository.save(post);
        return postSaved;
    }

    public Optional<Post> updatePost(long id, Post post) {
        Optional<Post> postToUpdate = postRepository.findById(id);
        if (postToUpdate.isPresent()) {
            Post _post = postToUpdate.get();
            _post.setTitle(post.getTitle());
            _post.setDate(post.getDate());
            _post.setMood(post.getMood());
            _post.setContent(post.getContent());
            Post postSaved = postRepository.save(_post);
            return Optional.of(postSaved);
        } else {
            return Optional.empty();
        }
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

    /**
     * Constructs a Map containing the following key value pairs: 1. posts, 2. currentPage, 3. totalItems, 4. totalPages
     * @param pagePost
     * @return Map containing the response
     */
    private Map<String, Object> constructMap(Page<Post> pagePost) {
        return Map.of("posts", pagePost.getContent(),
                "currentPage", pagePost.getNumber(),
                "totalItems", pagePost.getTotalElements(),
                "totalPages", pagePost.getTotalPages());
    }
}
