class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /* q is basically asking us to return two numbers
        in an array that sum up to become target
        BUT index 1 /= index 2 
        and index1 < index 2


        INTUITION: sorted array -> two pointers
        -> if current sum is too big, moving right pointer
        to the left makes the sum smaller
        -> if the current sum is too small, moving left pointer
        makes the sum bigger
        */

        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            int curSum = numbers[left] + numbers[right];

            if(curSum > target){
                right--;
            } else if (curSum < target){
                left++;
            } else {
                return new int[] {left + 1, right + 1};
                }
            }

        return new int[0];
    }
}
