class Solution {
    public int search(int[] nums, int target) {
        // similar to last, 
        // where we noticed a rotated array is two sorted arrays
        // stuck together

        int left = 0;
        int right = nums.length - 1;
        

        while(left <= right){
            int middle = left + (right - left) / 2;

            if (nums[middle] == target){
                // if num in middle is alr a target, just
                // return middle
                return middle;
            }

            if(nums[left] <= nums[middle]){
                // if nums on left are less than nums on middle
                // when is target invalid for the left half?
                // v
                if (target > nums[middle] || target < nums[left]){
                    // now check target, if target > mid
                    // or less than the numbers on left, 
                    // we check the right subtree
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                // this means the array is rotated so left is the technically
                // end of array

                // when is target invalid for the right half?
                if (target < nums[middle] || target > nums[right]){
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        
        
        }
        return -1;
    }
}

