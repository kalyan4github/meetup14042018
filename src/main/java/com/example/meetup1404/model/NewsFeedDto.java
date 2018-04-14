package com.example.meetup1404.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsFeedDto {

	private String link;
	  private String title;
	  private String contents;
	  private List<String> authors = new ArrayList<>();
	  private Date updatedDate;
	  private Date publishedDate;

	  public static NewsFeedDto from(NewsFeed newsFeed) {

	    NewsFeedDto newsFeedDto = new NewsFeedDto();
	    newsFeedDto.setTitle(newsFeed.getTitle());
	    newsFeedDto.getAuthors().addAll(newsFeed.getAuthors());
	    newsFeedDto.setContents(newsFeed.getContents());
	    newsFeedDto.setPublishedDate(newsFeed.getPublishedDate());
	    newsFeedDto.setUpdatedDate(newsFeed.getUpdatedDate());
	    newsFeedDto.setLink(newsFeed.getLink());
	    return newsFeedDto;
	  }

	  public String getLink() {
	    return link;
	  }

	  public void setLink(String link) {
	    this.link = link;
	  }

	  public String getTitle() {
	    return title;
	  }

	  public void setTitle(String title) {
	    this.title = title;
	  }

	  public String getContents() {
	    return contents;
	  }

	  public void setContents(String contents) {
	    this.contents = contents;
	  }

	  public List<String> getAuthors() {
	    return authors;
	  }

	  public void setAuthors(List<String> authors) {
	    this.authors = authors;
	  }

	  public Date getUpdatedDate() {
	    return updatedDate;
	  }

	  public void setUpdatedDate(Date updatedDate) {
	    this.updatedDate = updatedDate;
	  }

	  public Date getPublishedDate() {
	    return publishedDate;
	  }

	  public void setPublishedDate(Date publishedDate) {
	    this.publishedDate = publishedDate;
	  }
}
