package com.feng.blogs.service;

import java.util.List;

import com.feng.mongo.model.Blogs;
import com.feng.mongo.model.Pagination;

public interface BlogsService {

	public List<Blogs> findAll();
	
	public Pagination<Blogs> findBlogs(Blogs blogs, Pagination<Blogs> page);
}
