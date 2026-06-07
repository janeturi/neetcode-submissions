class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // goal is to use middle to figure out which half
        // to discard so we dont have to go through whole thing
        while(left <= right){
            int middle = left + ((right - left) / 2);
            // right - left because we dont want to count
            // left twice
            if(nums[middle] > target){
                right = middle - 1;
                // if mid is greater than target, we focus on
                // the lower middle half so change right
            } else if (nums[middle] < target){
                left = middle + 1;
                // if mid is less than target, we focus on the
                // greater middle half so change right
            } else {
                return middle;
                // else, it's middle
            }
        }
        return -1; // target wasn't found
    }
}
