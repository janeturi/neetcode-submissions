class Solution {
    public int trap(int[] height) {
        // this is similar to max area w containers i would say, but inverted in a way
        // intuition:
        /*
        - water depends on the shorter wall btwn left and right sides like in max area
        - this means, we can move the left or right pointer inward and calculate how much
        water can be trapped there
        */

        if (height == null || height.length == 0){ // null check
            return 0;
        } 

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left]; // highest wall seen from left
        int rightMax = height[right]; // highest wall seen from right
        int res = 0;
        while(left < right){ // traversing from left -> right, also checks
        // if we have any capacity period
            if(leftMax < rightMax){ // if the tallest wall is from the right,
            // and only shortest matters
                left++; // we traverse via left side
                leftMax = Math.max(leftMax, height[left]); // update highest wall seen so far
                res += leftMax - height[left]; // keeps track of water
        
            } else { // if the tallest wall is from the left, only shortest matters
                right--; 
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right]; 
            }
    }
    
    return res;
    }
}
