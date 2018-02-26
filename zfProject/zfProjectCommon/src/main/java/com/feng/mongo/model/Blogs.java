package com.feng.mongo.model;

import java.io.Serializable;
import java.util.Date;


public class Blogs implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String title;
	//摘要
	private String digest;
	
	private String author;
	//发布时间
	private Date pubdate;
	//点击量
	private int hits;
	//评论数
	private int comment;
	//点赞数
	private int tags;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public int getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "Blogs [id=" + id + ", title=" + title + ", digest=" + digest
				+ ", author=" + author + ", pubdate=" + pubdate + ", hits="
				+ hits + ", comment=" + comment + ", tags=" + tags+ ", url=" + url + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blogs other = (Blogs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setTags(int tags) {
		this.tags = tags;
	}
	
	
	
}
