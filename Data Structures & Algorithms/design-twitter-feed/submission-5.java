class Twitter {
    private static int timestamp = 0;
    private static final int MAX_TWEETS = 10;
    Map<Integer, Set<Integer>> following;
    PriorityQueue<Tweet> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new PriorityQueue<>((a, b) -> Long.compare(b.timestamp, a.timestamp));   
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.offer(new Tweet(timestamp++, userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> currentlyFollowing = new HashSet<>();
        if (following.containsKey(userId)) {
            currentlyFollowing = following.get(userId);
        }
        currentlyFollowing.add(userId);

        List<Tweet> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!tweets.isEmpty() && count < MAX_TWEETS) {
            Tweet tweet = tweets.poll();
            if (currentlyFollowing.contains(tweet.userId)) {
                count++;
                result.add(tweet.id);
            }
            temp.add(tweet);
        }
        temp.forEach(tweets::offer); 
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, v -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            return;
        }
        following.get(followerId).remove(Integer.valueOf(followeeId));
    }


    class Tweet {
        long timestamp;
        int userId;
        int id;

        public Tweet(long timestamp, int userId, int id) {
            this.timestamp = timestamp;
            this.userId = userId;
            this.id = id;
        }
    }
}
