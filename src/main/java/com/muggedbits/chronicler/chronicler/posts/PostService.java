package com.muggedbits.chronicler.chronicler.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public int getPostCount() {
        return (int) postRepository.count();
    }

    public List<Post> getPostsByTitle(String title) {
        List<Post> posts = new ArrayList<>();
        postRepository.findByTitleContaining(title).forEach(posts::add);
        return posts;
    }

    public List<Post> getPostsByDate(boolean ascending) {
        List<Post> posts = new ArrayList<>();
        if (ascending) {
            postRepository.findAllByOrderByDateAsc().forEach(posts::add);
        } else {
            postRepository.findAllByOrderByDateDesc().forEach(posts::add);
        }
        return posts;
    }

    public List<Post> getPostsByMood(boolean ascending) {
        List<Post> posts = new ArrayList<>();
        if (ascending) {
            postRepository.findAllByOrderByMoodAsc().forEach(posts::add);
        } else {
            postRepository.findAllByOrderByMoodDesc().forEach(posts::add);
        }
        return posts;
    }

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
}
