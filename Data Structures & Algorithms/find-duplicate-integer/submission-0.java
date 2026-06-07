class Solution {
    public int findDuplicate(int[] nums) {
        // given an array of integers nums containing n + 1 ints
        // each int is in range [1, n] inclusive
        // we want to return the integer that appears more than once
        // my idea, hashset or hashmap storing a 'seen' thing, works but 
        // has O(n) space complex, and we want to have O(1)

        int slow = 0;
        int fast = 0;
        // we can create the array like a linked list, where each index
        // points to the next index given by its value
        // which means that since there's a duplicate, two indicies
        // will point to the same thing and create a cycle
        
        
        while(true){ 
            slow = nums[slow];
            // moves 1 step
            fast = nums[nums[fast]];
            // moves 2 steps at a time
            if(slow == fast){ // if they ever meet, there's a garunteed
            // cycle
                break;
            }
        }

        int slow2 = 0;
        // now we we know there's a cycle, so we want to find the exact
        // digit
        while (true){
            slow = nums[slow];  // stays at collision
            // so slow is looping again and again between index -> number
            slow2 = nums[slow2]; // starts at beginning of index to
            // approach cycle
            if(slow == slow2){ // when number= number, there's a 
            // duplicate #
                return slow;
            }
        }
    }
}
