package com.example.meetup1404.service;

import java.util.List;

import com.example.meetup1404.model.NewsFeed;
import com.example.meetup1404.model.NewsFeedDto;

public interface NewsFeedService {

	List<NewsFeed> save(List<NewsFeed> newsFeeds);
	NewsFeed updateNewsFeed(NewsFeedDto newsFeedDto);
	NewsFeedDto saveNewsFeed(NewsFeedDto newsFeedDto);
	
	List<NewsFeedDto> getAllNewsFeed();
	NewsFeedDto getByTitle(String title);
	
	void deleteByTitle(String title);
}
