package com.feng.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.mongo.model.Blogs;
import com.feng.mongo.model.Pagination;

@RequestMapping("/blogs")
public interface BlogsInterface {

	@RequestMapping("/queryBlogs")
	public Pagination<Blogs> queryBlogs(@RequestBody Blogs blogs, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);
}
