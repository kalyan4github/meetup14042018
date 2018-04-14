package com.example.meetup1404.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndPerson;

@Document
public class NewsFeed {

	@Id
	  private String id;
	  private String link;
	  private String title;
	  private String contents;
	  private List<String> authors = new ArrayList<>();
	  private Date updatedDate;
	  private Date publishedDate;

	  public static NewsFeed from(NewsFeedDto newsFeedDto) {
	    NewsFeed newsFeed = new NewsFeed();
	    newsFeed.setTitle(newsFeedDto.getTitle());
	    newsFeed.getAuthors().addAll(newsFeedDto.getAuthors());
	    newsFeed.setContents(newsFeedDto.getContents());
	    newsFeed.setPublishedDate(newsFeedDto.getPublishedDate());
	    newsFeed.setUpdatedDate(newsFeedDto.getUpdatedDate());
	    newsFeed.setLink(newsFeedDto.getLink());
	    return newsFeed;
	  }

	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
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

	  public static List<NewsFeed> from(List<SyndEntry> syndEntries) {
	    return syndEntries.stream().map(NewsFeed::from)
	        .collect(Collectors.toList());
	  }

	  private static NewsFeed from(SyndEntry syndEntry) {
	    NewsFeed newsFeedDetails = new NewsFeed();
	    newsFeedDetails.setContents(syndEntry.getContents().get(0).getValue());
	    newsFeedDetails.setLink(syndEntry.getLink());
	    newsFeedDetails.setUpdatedDate(syndEntry.getUpdatedDate());
	    newsFeedDetails.setAuthors(syndEntry.getAuthors().stream().map(NewsFeed::getName)
	        .collect(Collectors.toList()));
	    newsFeedDetails.setPublishedDate(syndEntry.getPublishedDate());
	    newsFeedDetails.setUpdatedDate(syndEntry.getUpdatedDate());
	    newsFeedDetails.setTitle(syndEntry.getTitle());
	    return newsFeedDetails;
	  }

	  private static String getName(SyndPerson syndPerson) {
	    return syndPerson.getName();
	  }

	  public static NewsFeed from(NewsFeed newsFeed, NewsFeedDto newsFeedDto) {
	    newsFeed.setTitle(newsFeedDto.getTitle());
	    newsFeed.setContents(newsFeedDto.getContents());
	    newsFeed.setUpdatedDate(newsFeedDto.getUpdatedDate());
	    newsFeed.setPublishedDate(newsFeedDto.getPublishedDate());
	    newsFeed.setAuthors(newsFeedDto.getAuthors());
	    newsFeed.setLink(newsFeedDto.getLink());
	    return newsFeed;
	  }
}
