class Solution {
    public int findMin(int[] nums) {
        // originally sorted, now rotated between 1 and n times
        // rotations -> moves the last n numbers to the beginning
        // all elements are unique & we are finding the min

        int left = 0;
        int right = nums.length - 1;
        int res = nums[0];

        while(left <= right){
            if (nums[left] < nums[right]){
                // if the current window is already sorted
                res = Math.min(res, nums[left]);
                // return the nums[left] and stop
                break;
            }

            int middle = left + (right - left) / 2;
            res = Math.min(res, nums[middle]);
            // update res with middle 

            if (nums[middle] >= nums[left]){
                left = middle + 1;
                // if left half is already sorted,
                // move search to the right half
            } else {
                right = middle - 1;
                // if it's not sorted, move search to the left
            }
        }
        return res; // res will return the smallest value found
    }
}
