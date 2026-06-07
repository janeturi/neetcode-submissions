class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # sort array in place such thatelements of same color r grouped 2gether and arranged 012

        zero = one = 0 # pointers for 0 and 1
        for two in range(len(nums)): # pointer for 2
            tmp = nums[two] # save current pointer value
            nums[two] = 2 # now move it as 2 
            # if we eventually meet another 2, we dont do anythig and move on 
            if tmp < 2: # if our actual value is less than 2, we mark it as 1
                nums[one] = 1 #
                one += 1
            if tmp < 1: # if our saved value is less then 1, we mark it as 0
                nums[zero] = 0
                zero += 1