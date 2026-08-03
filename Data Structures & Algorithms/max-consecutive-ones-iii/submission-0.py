class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        l = 0
        res = 0
        
        for r in range(len(nums)): # expand window
            if nums[r] == 0: # if our right is 0, we decrease our budget by 1
                k -= 1
            
            while k < 0: # if we have no more to spend by r
                if nums[l] == 0: # we decrease our window only if its 0 
                    k += 1 # so we get k back
                l += 1 # move forward regardless to try out different k solutions
            
            res = max(res, r - l + 1)
            
        return res