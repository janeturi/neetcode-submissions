class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l <= r:
            m = l + (r - l) // 2 # mid
            if target == nums[m]: # return target if mid
                return m

            if nums[m] <= nums[r]: # if right part is sorted and inc
                if nums[m] <= target <= nums[r]: # target is in sorted part
                    l = m + 1 # we check the sorted
                else: # else its in the unsorted part os we check the other
                    r = m - 1
            else: # else, our left part is sorted
                if nums[l] <= target <= nums[m]: # if target is in sorted part
                    r = m - 1
                else: # or unsorted
                    l = m + 1
        return -1