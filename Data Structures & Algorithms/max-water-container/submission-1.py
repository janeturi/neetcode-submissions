class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # we want to choose any two bars to form a container
        # idea 1: start backwards, 
        # we know that choosing a shorter bar makes our area smaller,
        # so want to use two pointers. both ppointers will keep 
        # going inwards for as long as the next element is greater than the other
        # otherwise, it'll stop and stay there 
        # -> this method is greedy -> for the shorter line, keep moving and see
        # if theres a potential other container

        l, r = 0, len(heights) - 1
        res = 0 # stores max area
        
        while l < r:
            area = min(heights[l], heights[r]) * (r - l) # current area 
            res = max(res, area) 
            if heights[l] <= heights[r]: # we want to keep 
            # the tallest wall each time because there's no point in taking a 
            # smaller one
                l += 1
            else:
                r -= 1
        return res