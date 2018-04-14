package com.example.meetup1404.reader;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by imteyaz on 09/04/18
 **/

@Service
public class NewsFeedReaderImpl implements NewsFeedReader {

  final static Logger log = LoggerFactory.getLogger(NewsFeedReaderImpl.class);

  @Override
  public List<SyndEntry> readNewsFeed(String url) {

    try (InputStreamReader inputStreamReader = new InputStreamReader(new URL(
        url)
        .openStream())) {
      log.info("Reading feed for url {}", url);
      SyndFeed syndFeed = new SyndFeedInput().build(inputStreamReader);
      return syndFeed.getEntries().stream().filter(Objects::nonNull)
          .collect(Collectors.toList());
    } catch (IOException | FeedException e) {
      e.printStackTrace();
    }
    return Collections.EMPTY_LIST;
  }
}
