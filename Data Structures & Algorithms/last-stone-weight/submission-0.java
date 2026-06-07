class Solution {
    public int lastStoneWeight(int[] stones) {
        // array of ints stones where stones[i] = weight
        // at each step we choose 2 heaviest stones
        // with weight x and y and smash them togethers
        // (first two in a max heap)
        // if x == y, destroy both stones
        // if x < y, stone of weight x is destroyed and y's
        // weight is updated to y - x
        // continue until there is no more than 1 stone remaining
        // return the weight of last remaining stone or return 0
        
        // get away w using minHeap via negative integers (bc
        // the least aka biggest negative will also be the max
        // when positive)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s : stones) minHeap.offer(-s); // put in neg
        // values into minHeap

        while(minHeap.size() > 1){
            int first = minHeap.poll(); // store
            // vals of first and second
            int second = minHeap.poll(); 
            if(second > first){
                minHeap.offer(first - second); // update and
                // add new y value
                // first - second bc vlaues r flipped cuz neg
            }
        }

        minHeap.offer(0); // safety thing
        return Math.abs(minHeap.peek()); // remaining
        // one but as absolute value 
    }
}
