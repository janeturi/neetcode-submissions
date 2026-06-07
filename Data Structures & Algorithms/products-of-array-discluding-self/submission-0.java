class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        easy intuition, multiply everything and then divide LOLL, however
        problem is asking to do it without division , ok attempted and flopped
        but we move!! laugh and move on :)

        intuition:
        reuse result array and build answer in passes
        first pass: fill res[i] with prod of all elements ot the left
        second: multiply each res[i] with the prod of all elemenets to the right
        
        */

        int n = nums.length; 
        int[] res = new int[n];

        res[0] = 1; // need to start @ 1 so that everything isn't just 
        // erased by multiplying by 0
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1]; // result - 1 * the num
            // before the i
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){ // same idea, but backwards
            res[i] *= postfix; // multiplies everything in the prefix
            // by the postix
            postfix *= nums[i]; // then multiplies the rest 
        }

        return res;
        
    }
}  
