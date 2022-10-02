package com.blog.services;

import com.blog.payloads.CommentDto;


public interface CommentService {
	CommentDto ceateComment(CommentDto commentDto, Integer postId, Integer userId );
	void deleteComment(Integer commentId);
}
