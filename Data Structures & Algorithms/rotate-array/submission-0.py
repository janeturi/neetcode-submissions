class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # given an int array nums, rotate to the right by k steps
        # aka just ends and starts swap 
        # idea 1: elements before k go from i -> i + k
        # elements at or after k go from i -> i + k - n
        # -> move everything to these new indeces in a new array -> non-linear space complexity
        n = len(nums)
        tmp = [0] * n
        for i in range(n):
            tmp[(i + k) % n] = nums[i] 

        nums[:] = tmp # use [:] to change in place elements