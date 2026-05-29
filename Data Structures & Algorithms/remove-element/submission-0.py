class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        # give int array nums and val, remove all times val happens 
        # then return the number of elements in nums not equal to val
        # k must the first k elements are the elements not equal to val
        # the rest doesnt matter, so just push val to the back or dont have val at all

        # idea is to swap vals we see with the last element and then
        # shrink our valid range

        i = 0
        n = len(nums)
        while i < n:
            if nums[i] == val: # if we encounter val
                n -= 1 # decrease valid range (must go first or else error)
                nums[i] = nums[n] #replace w last element to push val at the end
            else:
                i += 1 # else we move to next element
        return n