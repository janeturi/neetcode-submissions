class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # given array of integers nums and + int target,
        # return the minimal length of array whose sum is >= target 

        # idea: similar idea to prev sliding window q's since we're finding a subarray, we
        # want to increase our right if we still need to reach a sum
        # then afterwards, shrink with our left pointer
        l, total = 0, 0
        res = float("inf") # use inf for int related stuff, anything is better than inf

        for r in range(len(nums)):
            total += nums[r] # add to our total as we expand r
            while total >= target: # once we reach a total >= target we can shrink oru 
            #left array
                res = min(r - l + 1, res) # we want to return the absolute smallest window
                total -= nums[l] # decrease total as we remove left
                l += 1 # move left pointer
        
        return 0 if res == float("inf") else res