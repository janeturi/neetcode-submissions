class Twitter {

    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

// goal is to use a heap that only stores their 10
// most recent tweets to reduce use of memory and improves time

// you do this by appending a decreasing timestamp, count
// and keeping only the last 10 tweets

    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(
            new int[]{count, tweetId});
            // if missing in map, insert a (timestamp, tweetId) at the
            // of of the user's list, or place in tweetmap
            if(tweetMap.get(userId).size() > 10) {
                tweetMap.get(userId).remove(0);
                // remove oldest tweet
            }
            count--; // decrease global timestamp so newer
            // tweets have smaller values and are at top of minHeap
            // (good to think in terms of itme, 25 secs vs 50 secs)
        }
        
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(
            a[0], b[0])
            );
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        // adds user's self so user can look at themselves too
        if(followMap.get(userId).size() >= 10){ // followees more thn 10
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(a[0], b[0])
            ); // build a maxHeap storing only the top 10 most
            // recent tweets across followees
            for(int followeeId : followMap.get(userId)){
                if(!tweetMap.containsKey(followeeId)) continue; // continue even
                // if the user doesnt follow a lot of ppl
                List<int[]> tweets = tweetMap.get(followeeId); // convert tweets
                // to a list
                int index = tweets.size() - 1; // sets indices
                int[] tweet = tweets.get(index); // gets indiv tweets
                maxHeap.offer(new int[]{-tweet[0], tweet[1], followeeId, index - 1});
                // convert to minHeap so that we the older ones get deleted
                if(maxHeap.size() > 10){
                    maxHeap.poll(); // remove eldest if > 10
                } 
            }
            while(!maxHeap.isEmpty()){
                int[] top = maxHeap.poll();
                minHeap.offer(new int[]{-top[0], top[1], top[2], top[3]});
                // convert to a minHeap to return in chronological order
                // on your feed
            }
        } else {
            for(int followeeId : followMap.get(userId)) {
                if(!tweetMap.containsKey(followeeId)) continue;
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index - 1});
                // push the newest tweet from each followee into a minHeap, we don't 
                // need to remove any old tweets or anything so it's ok :)
            }
        }

        while(!minHeap.isEmpty() && res.size() < 10){ // limits to 10 and
        // we have more tweets to push
            int[] top = minHeap.poll(); 
            res.add(top[1]); // newest add tweet to result
            int nextIndex = top[3]; // next tweet
            if(nextIndex >= 0){
                List<int[]> tweets = tweetMap.get(top[2]); 
                int[] nextTweet = tweets.get(nextIndex);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIndex - 1});
                // return and push next tweet from the same followee 
                // until we reach 10
            }
        }
        return res; 
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        // add followee to follower's follow-set if not in there
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
            // remove the followee if they exist in the follower's list
        }
    }
}
