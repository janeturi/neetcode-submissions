class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // wan tto eat minimum k, banana per hr eating rate,
        // such that we can eat all the bananas within h hours
        // - if a pile has less than k bananas, you can finish eating
        // from the pile but u cant start eating the next pile
        // piles[i] contains the number of bananas in the ith pile


        // total time needed decreases as eating speed increases
        // meaning, time is sorted in a non-increasing order
        int left = 1; // minimum possible speed
        int right = Arrays.stream(piles).max().getAsInt();
        // max needed speed,
        // arrays.stream is a way to traverse piles
        // without writing a for loop, but just as one line
        // so now right represents the max value in piles
        int res = right;
        
        while(left <= right){
            int k = (left + right) / 2;

            long totalTime = 0;
            for(int p : piles) {
                totalTime += Math.ceil((double) p / k);
                // rounds up to the nearest integer written
                // as a double
            } 
            if (totalTime <= h){
                // if total time is within the max hours we're allowed
                // then it works and we record it.
                // we're finding minimum so now we search through left
                // in case there's a diff minimum speed
                res = k;
                right = k - 1;
            } else {
                // else, the speed is too slow and we need to traverse
                // the right
                left = k + 1;
            }
        }
        return res;
    }
}
