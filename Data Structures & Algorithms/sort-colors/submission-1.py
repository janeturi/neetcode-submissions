class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r = 0, len(nums) - 1 # we use left and right boundaries to find spots where we can move and replace our numbers
        curr = 0
        while curr <= r: # while our curr hasnt reached the end
            if nums[curr] == 0: # if our current number is 0, then
            # this means we want to swap whatever is at left with middle to keep all our 0s at the left
                nums[l], nums[curr] = nums[curr], nums[l]
                l += 1 # then we just move
                curr += 1
            elif nums[curr] == 1: # if it's one, then it's perfectly inn the middle so we just ignore
                curr += 1
            else:
                # if its 2, we swap to the right,
                # so we shrink but we haven't processed whatever is now at our curr now so we dont skip past it
                nums[curr], nums[r] = nums[r], nums[curr]
                r -= 1
        
