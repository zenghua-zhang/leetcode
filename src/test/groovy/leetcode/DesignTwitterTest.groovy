package leetcode

class DesignTwitterTest extends GroovyTestCase {
    DesignTwitterTest _obj

    DesignTwitter.Twitter twitter

    void setUp() {
        super.setUp()
        _obj = new DesignTwitterTest()
        twitter = new DesignTwitter.Twitter()
    }

    void test() {
        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        println twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);
        twitter.postTweet(2, 7);
        twitter.postTweet(2, 8);
        twitter.postTweet(2, 9);


        println twitter.getNewsFeed(1);

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 12);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 14);
        twitter.postTweet(1, 15);
        twitter.postTweet(1, 16);
        twitter.postTweet(1, 17);
        twitter.postTweet(1, 18);
        twitter.postTweet(1, 19);
        twitter.postTweet(1, 20);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        println twitter.getNewsFeed(1);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        println twitter.getNewsFeed(1);

    }

    void test_1() {
        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        twitter.follow(1, 1)

        println twitter.getNewsFeed(1)

    }

    void test_2() {
        // User 1 posts a new tweet (id = 5).
        [[1, 5], [1, 3], [1, 101], [1, 13], [1, 10], [1, 2], [1, 94], [1, 505], [1, 333], [1, 22]].each {

            twitter.postTweet(it[0], it[1])
        }



        println twitter.getNewsFeed(1)

    }

}
