class KthLargest {
// a stream is basically just an array of numbers that can
// be added onto later using add

// we are using a minHeap because of this, since minHeaps
// allow us to use what we have so far and allows for dynamicnes
// which is why we cant just use and store a new array each time.

private PriorityQueue<Integer> minHeap;
private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k; 
        this.minHeap = new PriorityQueue<>();
        for (int num : nums){ // store initial numbers in an array
            minHeap.offer(num); 
            if(minHeap.size() > k){  // if minHeap has more than k
            // elements (we only need k elements)
                minHeap.poll(); // remove the smallest, bc the smallest is 
                // stored at the top
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val); // do the same for added numbers
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek(); // returns the kth largest element
        // because it goes from 1 ... k
    }
}
