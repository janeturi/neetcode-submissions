class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        # given array of nums, return 4 unique elements s.t.
        # 0 <= a, b, c, d < n
        # and all 4 sum to target
        # idea: sort, use 2 fixed nums instead of just 1
        # hten same logic as prev numsum solutions where if too small, inc left, too big- dec right

        nums.sort()
        n = len(nums)
        res = []

        for i in range(n): # first stationary
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, n): # 2nd stationary, both check for possible dupes
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                l, r = j + 1, n - 1
                while l < r:
                    sum = nums[i] + nums[j] + nums[l] + nums[r]
                    if sum == target:
                        res.append([nums[i], nums[j], nums[l], nums[r]])
                        l += 1
                        r -= 1
                        while l < r and nums[l] == nums[l - 1]:
                            l += 1 # check for dupes again for our for loops while we're checking for other
                            # triples
                    elif sum < target: 
                        l += 1
                    else:
                        r -= 1
                        
        return res
                            