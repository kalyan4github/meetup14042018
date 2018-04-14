package com.example.meetup1404.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meetup1404.model.NewsFeed;
import com.example.meetup1404.model.NewsFeedDto;
import com.example.meetup1404.repo.NewsFeedRepo;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {

	private final NewsFeedRepo newsFeedRepo;

	  @Autowired
	  public NewsFeedServiceImpl(NewsFeedRepo newsFeedRepo) {
	    this.newsFeedRepo = newsFeedRepo;
	  }

	  @Override
	  public List<NewsFeed> save(List<NewsFeed> newsFeeds) {
	    return newsFeedRepo.saveAll(newsFeeds);
	  }

	  @Override
	  public NewsFeed updateNewsFeed(NewsFeedDto newsFeedDto) {
	    NewsFeed newsFeed = newsFeedRepo.findByTitle(newsFeedDto.getTitle());

	    if (Objects.nonNull(newsFeed)) {
	      newsFeed = NewsFeed.from(newsFeed, newsFeedDto);
	    }
	    return newsFeedRepo.save(newsFeed);
	  }

	  @Override
	  public NewsFeedDto saveNewsFeed(NewsFeedDto newsFeedDto) {
	    return NewsFeedDto.from(newsFeedRepo.save(NewsFeed.from(newsFeedDto)));
	  }

	  @Override
	  public List<NewsFeedDto> getAllNewsFeed() {

	    return newsFeedRepo.findAll().stream().map(NewsFeedDto::from)
	        .collect(Collectors.toList());
	  }

	  @Override
	  public NewsFeedDto getByTitle(String title) {
	    return NewsFeedDto.from(newsFeedRepo.findByTitle(title));
	  }

	  @Override
	  public void deleteByTitle(String title) {
	    NewsFeed newsFeed = newsFeedRepo.findByTitle(title);
	    if (Objects.nonNull(newsFeed)) {
	      newsFeedRepo.delete(newsFeed);
	    }
	  }
}
