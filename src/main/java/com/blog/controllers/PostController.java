package com.blog.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.config.AppConstants;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.FileService;
import com.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;
	
	// create
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId) {
		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	}

	// update post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("postId") Integer postId) {
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}

	// delete post
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") Integer postId) {
		this.postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("post deleted successfully", true), HttpStatus.OK);
	}

	// get post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Integer postId) {
		PostDto postDto = this.postService.getPostByid(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	// get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy
			) {
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

	// get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("userId") Integer userId) {
		List<PostDto> posDtos = this.postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posDtos, HttpStatus.OK);
	}

	// get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategoru(@PathVariable("categoryId") Integer categoryId) {
		List<PostDto> posDtos = this.postService.getAllPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posDtos, HttpStatus.OK);
	}
	//search
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPoastByTitle(@PathVariable("keyword") String keyword){
		List<PostDto> searchPosts = this.postService.searchPosts(keyword);
		return new ResponseEntity<List<PostDto>>(searchPosts,HttpStatus.OK);
	}
	
	//post image upload
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId
			) throws IOException{
		String fileName = this.fileService.uploadImage(path, image);
		PostDto postDto = this.postService.getPostByid(postId);
		postDto.setImageName(fileName);
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
		
	}
}
