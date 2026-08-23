class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # given array nums of size n, return maority element
        # ??? count freq return num w the greatest freq??
        # yes -> but leads to O(n) which isn't optimal

        nums.sort()
        return nums[len(nums) // 2]
        # we're tol that the majority element is the element appearing
        # more then n/2 times in the array
        # so if it's sorted, it's whatever is in the middle
