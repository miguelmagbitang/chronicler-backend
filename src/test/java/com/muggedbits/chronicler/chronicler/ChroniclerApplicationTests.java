package com.muggedbits.chronicler.chronicler;

import com.muggedbits.chronicler.chronicler.posts.Post;
import com.muggedbits.chronicler.chronicler.posts.PostRepository;
import com.muggedbits.chronicler.chronicler.posts.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ChroniclerApplicationTests {

//	@Autowired
//	private PostService postService;
//
//	@MockBean
//	private PostRepository repository;
//
//	@Test
//	void getAllPostTest() {
//		Mockito.when(repository.findAll()).thenReturn(
//				Stream.of(new Post("title", LocalDate.of(1970, 1, 1), 10, "sample"),
//						new Post("title", LocalDate.of(1970, 1, 1), 10, "sample"),
//						new Post("title", LocalDate.of(1970, 1, 1), 10, "sample"))
//				.collect(Collectors.toList())
//		);
//		assertEquals(3, postService.getAllPosts().size());
//	}
//
//	@Test
//	void getPostCountTest() {
//		Mockito.when(repository.count()).thenReturn((long) 20);
//		assertEquals(20, postService.getPostCount());
//	}
//
//	@Test
//	void getPostByTitleTest() {
//		Mockito.when(repository.findByTitleContaining("Example")).thenReturn(
//				Stream.of(new Post("Example title", LocalDate.of(1970, 1, 1), 10, "sample"),
//						new Post("Example 2", LocalDate.of(1970, 1, 2), 10, "sample"))
//						.collect(Collectors.toList())
//		);
//		assertEquals(2, postService.getPostsByTitle("Example").size());
//	}
//
//	@Test
//	void createPostTest() {
//		Post post = new Post("Example", LocalDate.of(2020, 1, 1), 10, "sample");
//		Mockito.when(repository.save(post)).thenReturn(post);
//		assertEquals(post, postService.createPost(post));
//	}
//
//	@Test
//	void deletePostTest() {
////		Post post = new Post("Example", LocalDate.of(2020, 1, 1), 10, "sample");
//		postService.deletePost(1);
//		postService.deletePost(1);
//		postService.deletePost(2);
//		Mockito.verify(repository, Mockito.times(2)).deleteById((long) 1);
//	}

}
