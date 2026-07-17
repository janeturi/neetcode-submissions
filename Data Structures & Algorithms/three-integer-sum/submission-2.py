class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # given array nums return 3 unique nums that sum to 0
        # idea 1: sort -> have a 'stationary' number and then two pointers 
        # on left and right, move left up if too small, move right down if too big
        # -> possible time complexity too big issue? -> ok nvm optimal oslution is O(n^2) so this is right

        res = []
        nums.sort()

        for i, a in enumerate(nums): # enumerate default is 0 and mvoes on
         # use regular for loop and initialization for count, freq, etc problems
            if i > 0 and a == nums[i - 1]: # skip duplicates
                continue
                
            if a > 0: # if our very first fixed number is > 0,
            # bc it's sorted, it cant have any other negatuve numbers after this so no valid solutions
                break



            l, r = i + 1, len(nums) - 1
            while l < r:
                threeSum = a + nums[l] + nums[r] # our sum
                if threeSum > 0:
                    r -= 1 # if our sum is too big, we need to decrease r
                elif threeSum < 0: 
                    l += 1 # if our sum is too small, we need to increase l
                else:
                    # if == 0
                    res.append([a, nums[l], nums[r]])
                    l += 1 # move on and check for remaining triplets
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r: # if duplicate found skip past it
                    # always use a l < r or boundary if incrementing count like this for boundary issues!
                        l += 1
        return res