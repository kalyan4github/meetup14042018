package com.example.meetup1404.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.meetup1404.model.NewsFeed;

public interface NewsFeedRepo extends MongoRepository<NewsFeed, String> {

	NewsFeed findByTitle(String title);
}
