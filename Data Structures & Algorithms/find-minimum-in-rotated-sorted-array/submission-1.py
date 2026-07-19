class Solution:
    def findMin(self, nums: List[int]) -> int:
    # use binary search to find the section of the array that is the largest/smallest
    # just bc we know it's sorted, so we need to figure out where the smaller half is to find where our min is
        l, r = 0, len(nums) - 1
        while l < r:
            m = l + (r - l) // 2 # mid , use r - l just for memory reasons
            if nums[m] < nums[r]: # if our middle value is less than where our right pointer is,
            # then that means that r is the greaer half so shrink our window to have r at mid
                r = m
            else:
                l = m + 1 # else, our right holds the smaller values so we set oru left to look at the right half
        return nums[l] # and just bc its sorted we can reeturn nums[l]