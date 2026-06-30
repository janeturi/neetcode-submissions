class Solution:
    def trap(self, height: List[int]) -> int:
        # given an array of int heights, we
        # want to return the max area of water that can be trapped
        # btwn bars -> our area can max be the height of the shortest bar
        # so whichever is shortest, we move inwards and calculate + add the res 
        # of that array + don't include the edges, they aren't bars and the water will overflow.
        res, l, r = 0, 0, len(height)  - 1 # floors
        leftMax, rightMax = height[l], height[r] # walls
        while l < r:
            if leftMax < rightMax: # if our left wall is shorter, we calculate the left
                l += 1 # move over
                leftMax = max(leftMax, height[l]) # calculate wall length 
                res += leftMax - height[l] # tall wall - 
            else: # same as b4
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
        return res