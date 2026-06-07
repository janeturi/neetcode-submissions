class Solution {
    public int maxArea(int[] heights) {
      // two pointers are good for searching max area without checking every pair

      // to potentially increase area, we move the pointer at the shorter line
      // inward/right
      // moving taller line doesn't help bc it keeps height the same
      // but reduces width 
      

      int left = 0;
      int right = heights.length - 1;
      int max = 0;

      while(left < right){
        int area = Math.min(heights[left], heights[right]) * (right - left); // current area
        // choose min between left and right because the tallest one doesnt add 
        // to the max area, * right - left for horizontal distance
        max = Math.max(max, area);

        if(heights[left] <= heights[right]){ // this is to check
        // for potential increases in area by moving pointer
        // at shorter line inward
            left++; // so if the left is the min, we move it ahead
        } else {
            right--; // and if the right is the min, we move it ahead
        }
      }
      return max;
    }
}
