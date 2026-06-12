class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # idea is to split everything into parts excluding i
        
        res = [1] * (len(nums)) # empty array, use 1 to multiply 

        prefix = 1
        for i in range(len(nums)): # prod of all elements to the left 
            res[i] = prefix 
            prefix *= nums[i]  
        postfix = 1
        for i in range(len(nums) - 1, -1, -1): # goes backwards
            res[i] *= postfix
            postfix *= nums[i]
        return res
        