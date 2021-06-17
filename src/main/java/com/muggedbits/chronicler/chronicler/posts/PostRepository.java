package com.muggedbits.chronicler.chronicler.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContaining(String title, Pageable pageable);

    Page<Post> findAllByOrderByMoodAsc(Pageable pageable);

    Page<Post> findAllByOrderByMoodDesc(Pageable pageable);

    Page<Post> findAllByOrderByDateAsc(Pageable pageable);

    Page<Post> findAllByOrderByDateDesc(Pageable pageable);
}
