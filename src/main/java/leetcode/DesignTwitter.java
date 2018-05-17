package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

  class Twitter {

    private int tweetId = 0;

    private Map<Integer, User> userMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
      userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
      User user = getUser(userId);
      Tweet tweet = new Tweet(this.tweetId++, tweetId);
      user.postTweet(tweet);

    }

    private User getUser(int userId) {
      User user = userMap.get(userId);
      if (null == user) {
        user = new User(userId);
        userMap.put(userId, user);
      }
      return user;

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by
     * the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

      return getUser(userId).getNewsFeed();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
      User follower = getUser(followerId);
      User followee = getUser(followeeId);

      follower.follow(followee);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
      User follower = getUser(followerId);
      User followee = getUser(followeeId);

      follower.unfollow(followee);
    }

    private class User {

      int id;

      private LinkedList<Tweet> tweets = new LinkedList<>();

      private Set<User> follows = new HashSet<>();

      public User(int id) {
        this.id = id;
      }

      public void postTweet(Tweet tweet) {
        if (tweets.size() >= 10) {
          tweets.removeLast();
        }
        tweets.push(tweet);
      }

      public void follow(User user) {
        if (this == user) {
          return;
        }
        follows.add(user);
      }

      public void unfollow(User user) {
        follows.remove(user);
      }

      public List<Integer> getNewsFeed() {
        PriorityQueue<Tweet> queue = new PriorityQueue<>();
        queueHelper(queue, tweets);
        for (User user : follows) {
          queueHelper(queue, user.tweets);
        }

        List<Integer> ret = new ArrayList<>();

        if (queue.size() == 0) {
          return ret;
        }

        while (!queue.isEmpty()) {
          ret.add(queue.poll().number);
        }

        Collections.reverse(ret);

        return ret;
      }

      private void queueHelper(PriorityQueue<Tweet> queue, LinkedList<Tweet> tweets) {
        for (Tweet tweet : tweets) {
          queue.add(tweet);
          if (queue.size() > 10) {
            queue.poll();
          }
        }
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        User user = (User) o;
        return id == user.id;
      }

      @Override
      public int hashCode() {

        return Objects.hash(id);
      }
    }

    private class Tweet implements Comparable {

      int id;

      Integer number;

      public Tweet(int id, int number) {
        this.id = id;
        this.number = number;
      }

      @Override
      public int compareTo(Object o) {
        return id - ((Tweet) o).id;
      }
    }

  }
}
