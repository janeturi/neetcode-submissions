class Solution {
    public int maxProduct(int[] nums) {
       /*
       given integer array nums, find a 
       subarray that has the largest product within
       the array and return it

       subarray is a nonempty seq of elements within 
       an array

        i misread the question, but 
        we want to only use numbers in a row
       */ 


        // kadane solution tracks two values:
        // curMax = max product ending at the index ur on
        // curMin = min product ending at the index
        // we keep track of this bc if num at index is negative
        // then cur * min, if min is negative then itll be like
        // negative * negative = negative * big negative
        // so it actually becomes the max

        // so we know + * + = + 
        // - * + = -
        // but also - * -, so we need to make sure
        // we take care of that

       int res = nums[0];
       int curMin = 1, curMax = 1;

       for(int num : nums){
        int tmp = curMax * num; // curMax * res
        curMax = Math.max(Math.max(num * curMax, num * curMin), num);
        // check if curMax can be + * + but also account for possible negatives'
        // or if we can continue to increase length of the subarray window
        curMin = Math.min(Math.min(tmp, num * curMin), num);
        // min is current product orrrr the + * - solution orrr
        // the new number
        res = Math.max(res, curMax); // update res
       }
       return res;
    }
}
