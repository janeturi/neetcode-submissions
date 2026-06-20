class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # given unsorted integer array nums, we want to return
        # smallest positive integer not in nums
        # idea 1: i think we can use a hashmap somehow
        # ignore all negative numbers and from there, lookup if 
        # n + 1 exists from 0?? this uses too much space tho
        # ok so idea 2: ignore all negative numbers, then swap
        # and move numbers around so that our indexes match the 
        # value it is.. so like whatever is the first from 0
        # to not be = to its index means we have a missing positive
        # we can return

        n = len(nums)
        i = 0

        while i < n:
            if nums[i] <= 0 or nums[i] > n: # skip the numbers that r negative
            # or way bigger than n bc wat the point
                i += 1
                continue
            
            index = nums[i] - 1
            if nums[i] != nums[index]: # if they dont match
                nums[i], nums[index] = nums[index], nums[i] # we move the number to where it should belong if it was a regular sorted array
            else:
                i += 1 # once swapped we move on

        for i in range(n):
            if nums[i] != i + 1: # the first one our array number doesnt match
            # the value it should be
                return i + 1 # is our ans

        return n + 1 # else, we can just return n + 1
                