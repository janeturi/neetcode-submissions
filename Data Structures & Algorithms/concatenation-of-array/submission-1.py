class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        
        # given int array nums of length n, we want to 
        # create an array ans of length 2n where
        # the nums and ans are identical and
        # ans[i+n] == nums[i]

        # in other words, ans is the concatenation of two nums arrays
        # initially, i thought we can just append everything once and then append again to the end
        # but this results in a longer time complexity

        # this revised method defines it such that we fill it both at the 
        # same time
        n = len(nums) 
        ans = [0] * (2 * n) # sets length of answer to be 2 * n
        for i, num in enumerate(nums): 
            ans[i] = ans[i + n] = num # ans[i] = ans[i + after full pass] = the same number
        return ans