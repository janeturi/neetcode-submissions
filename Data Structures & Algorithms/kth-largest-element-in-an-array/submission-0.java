class Solution {
    public int findKthLargest(int[] nums, int k) {
        // same as before, but we need to upload the kth
        // largest w/o sorting

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // minheap keeps smallest element at the top
        // having a heap a size of k, heap always has k largest 
        // elements seen so far
        // smallest among k will be the kth largest elmeent

      
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){ // if heap size exceeds k,
                minHeap.poll(); // pop smallest element
            }
        }
        return minHeap.peek(); // top of the heap is the kth largest
        // becuase minHeap.peek returns the smallest. so if there are k - 1
        // larger numbers, we can return k
    }
}
