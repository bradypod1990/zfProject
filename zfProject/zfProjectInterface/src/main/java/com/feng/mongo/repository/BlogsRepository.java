package com.feng.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.feng.mongo.model.Blogs;

@Repository
public interface BlogsRepository extends MongoRepository<Blogs, String>{

}
