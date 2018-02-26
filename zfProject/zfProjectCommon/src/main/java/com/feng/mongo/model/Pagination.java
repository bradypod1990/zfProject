package com.feng.mongo.model;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	//总记录数
	private long totalNum;
	//第几页
	private int pageNum;
	//每页条数
	private int pageSize;
	//总页数
	private int pageCount;
	
	private List<T> entityList;
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Pagination() {
		this.pageNum = 1;
		this.pageSize = 10;
	}
	public Pagination(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<T> getEntityList() {
		return entityList;
	}
	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

}
