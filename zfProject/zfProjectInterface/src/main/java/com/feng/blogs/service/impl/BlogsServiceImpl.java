package com.feng.blogs.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.feng.blogs.service.BlogsService;
import com.feng.mongo.model.Blogs;
import com.feng.mongo.model.Pagination;

@Service
public class BlogsServiceImpl implements BlogsService{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Value("${collection.names.blogsName}")
	private String collectionName;
	
	public List<Blogs> findAll() {
		List<Blogs> list = mongoTemplate.findAll(Blogs.class, collectionName);
		if(list != null) {
			return list;
		}
		return Collections.emptyList();
	}
	
	public Pagination<Blogs> findBlogs(Blogs blogs, Pagination<Blogs> page) {
		Query query = new Query();
		if(blogs != null) {
			if(StringUtils.isNotEmpty(blogs.getTitle())) {
				query.addCriteria(Criteria.where("title").regex(blogs.getTitle()));
			}
			if(StringUtils.isNotEmpty(blogs.getAuthor())) {
				query.addCriteria(Criteria.where("author").regex(blogs.getAuthor()));
			}
			if(StringUtils.isNotEmpty(blogs.getUrl())) {
				query.addCriteria(Criteria.where("url").is(blogs.getUrl()));
			}
		}
		long sum = mongoTemplate.count(query, collectionName);
		if(page != null) {
			query.skip((page.getPageNum()-1)*page.getPageSize());
			query.limit(page.getPageSize());
		}
		List<Blogs> list = mongoTemplate.find(query, Blogs.class, collectionName);
		page.setEntityList(list);
		page.setTotalNum(sum);
		int pageCount = (int) (((sum-1)/page.getPageSize()) + 1);
		page.setPageCount(pageCount);
		return page;
	}
}
