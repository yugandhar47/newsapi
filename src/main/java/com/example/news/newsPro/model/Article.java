package com.example.news.newsPro.model;

import javax.persistence.*;

@Entity
public class Article {
	
	@Id
    private String id;
	@ManyToOne
    @JoinColumn(name = "sourceid")
    private Source sourceid;
	private String author;
	private String title;
	private String description;
	private String url;
	private String url_to_image;
	private String published_at;
	private String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Source getSourceid() {
		return sourceid;
	}
	public void setSourceid(Source sourceid) {
		this.sourceid = sourceid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl_to_image() {
		return url_to_image;
	}
	public void setUrl_to_image(String url_to_image) {
		this.url_to_image = url_to_image;
	}
	public String getPublished_at() {
		return published_at;
	}
	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
