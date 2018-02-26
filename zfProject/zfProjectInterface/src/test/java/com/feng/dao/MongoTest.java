package com.feng.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.feng.common.CommonTest;
import com.feng.mongo.model.Student;

public class MongoTest extends CommonTest{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void insertTest() {
		Random r = new Random();
		List<Student> list = new ArrayList<Student>();
		for(int i=0; i<100; i++) {
			Student s = new Student();
			s.setId("aaaaa-"+i);
			s.setAddress("fujian" + i);
			s.setName("zoufeng" + i);
			s.setAge(r.nextInt(100));
			list.add(s);
		}
		
		mongoTemplate.insertAll(list);
	}
	
	@Test
	public void delTest() {
		mongoTemplate.remove(Query.query(Criteria.where("name").regex(Pattern.compile(".*"))), "student");
//		mongoTemplate.dropCollection(Student.class);
	}
	@Test
	public void findTest() {
//		mongoTemplate.remove(Query.query(Criteria.where("*")), "student");
		List<Student> list = mongoTemplate.find(Query.query(Criteria.where("age").lte(50)), Student.class);
		if(list != null) {
			for(Student s : list) {
				System.out.println(s);
			}
		}
	}
}
