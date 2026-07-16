class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # idea is to split everything into parts excluding i
        
        res = [1] * (len(nums)) # empty array, use 1 to multiply 

        prefix = 1
        for i in range(len(nums)): # prod of all elements to the left 
            res[i] = prefix # our result arra
            prefix *= nums[i] # we multiply our prefix 
        postfix = 1
        for i in range(len(nums) - 1, -1, -1): # goes backwards bc (start, stop, step)
            res[i] *= postfix
            postfix *= nums[i]
        return res
        