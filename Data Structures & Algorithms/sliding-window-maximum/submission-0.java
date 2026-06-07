class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // idea: use a deque to track max in a sliding window
        // deque stores indices of element sin decreasing order of their values
        // this means the front of the deque holds max
        // we can remove smaller elements when pushing a new number
        // if the element at the front falls out of window,w e remove
        int n = nums.length;
        int[] output = new int[n - k + 1];
        // result initialized as array of size of array, - window size, + 1
        // for index
        Deque<Integer> q = new LinkedList<>();
        int left = 0;
        int right = 0;

        while(right < n){  // while right side of window is less than 
        // the array of integers
            while(!q.isEmpty() && nums[q.getLast()] < nums[right]){
                q.removeLast(); // while queue isn't empty and last bit of
                // queue is less than the right, we remove them b/c
                // they're smaller than the bigger number at the front
            }
            q.addLast(right); // add the new index to the deque

            if(left > q.getFirst()){
                // if the left pointer passes the first element in the queue,
                // then the first element is out of the window
                q.removeFirst();
            }

            if((right + 1) >= k){
                // once queue reaches size k, the front is the max
                // so u just add it to output array
                output[left] = nums[q.getFirst()];
                left++;
            }
            right++; // move foward in window
        }
        return output;
    }
}
