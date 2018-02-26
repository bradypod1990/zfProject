package com.feng.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feng.blogs.service.BlogsService;
import com.feng.interfaces.BlogsInterface;
import com.feng.mongo.model.Blogs;
import com.feng.mongo.model.Pagination;

@RestController
public class BlogsController implements BlogsInterface{

	@Autowired
	private BlogsService blogsService;

	
	public Pagination<Blogs> queryBlogs(@RequestBody Blogs blogs, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		Pagination<Blogs> page = new Pagination<Blogs>(pageNum, pageSize);
		return blogsService.findBlogs(blogs, page);
	}
}
