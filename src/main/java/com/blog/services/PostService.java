package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	//delete
	void deletePost(Integer postId);
	//get
	PostDto getPostByid(Integer postId);
	//get all
	PostResponse getAllPost(Integer pageNumber, Integer pageSize);
	//get all post by user
	List<PostDto> getAllPostByUser(Integer userid);
	//get all post by category
	List<PostDto> getAllPostByCategory(Integer categoryId);
	//search posts
	List<PostDto> searchPosts(String keyword);
}
