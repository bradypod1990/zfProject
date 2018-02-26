package com.feng.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feng.mongo.model.Blogs;
import com.feng.mongo.model.Pagination;
import com.feng.service.BlogsService;


@Controller
public class IndexController {

	private Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	private BlogsService blogsService;
	
	@RequestMapping("/")
	public String index(@RequestParam(defaultValue="1",required=false) int pageNum, @RequestParam(required=false) String title,  ModelMap model) {
		Blogs blogs = new Blogs();
		blogs.setTitle(title);
		Pagination<Blogs> page = blogsService.queryBlogs(blogs, pageNum, 10);
		model.put("page", page);
		return "index";
	}
	@RequestMapping("/error2")
	public String error() {
		logger.info("hello error");
		return "error";
	}
}
