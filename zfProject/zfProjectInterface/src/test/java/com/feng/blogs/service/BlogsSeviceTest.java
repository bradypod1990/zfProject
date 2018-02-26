package com.feng.blogs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.feng.blogs.service.impl.BlogsServiceImpl;
import com.feng.common.CommonTest;
import com.feng.mongo.model.Blogs;
import com.feng.mongo.model.Pagination;


public class BlogsSeviceTest extends CommonTest{

	@Autowired
	private BlogsServiceImpl blogsServiceImpl;
	
	
	@Test
	public  void testFindAll() {
		List<Blogs> list = blogsServiceImpl.findAll();
		System.out.println(list);
	}
	
	@Test
	public void testFindTitle() {
		Blogs b = new Blogs();
		//b.setTitle("Elasticsearch基础入门");
		//b.setUrl("https://my.oschina.net/codingcloud/blog/1615717");
		Pagination page = new Pagination();
		page.setPageNum(1);
		page.setPageSize(10);
		blogsServiceImpl.findBlogs(b, page);
		List<Blogs> list = page.getEntityList();
		if(!list.isEmpty()) {
			for(Blogs blogs: list) {
				System.out.println(blogs);
			}
		}
	}
}
