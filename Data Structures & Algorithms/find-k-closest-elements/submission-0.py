class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # given sroted array and two ints k and x, return k closest
        # ints to x in the array where res is sorted in ascending order
        # we're told everything is sorted in ascending order, so we can 
        # have both pointers start at x and expand from left and right so that
        # we can capture the closest on both sides, add the one with smallest distance each time
        # this works but is slow. the most optimal solution isnt a sliding wndow 

        # we know we want to find k elements, so we can use a search array to find the starting
        # index for our sliding window
        l, r = 0, len(arr) - k
        # so our window is prefixed at size k
        while l < r:
            m = (l + r) // 2 # we start the middle, 
            if x - arr[m] > arr[m + k] - x: # if the target - middle, it should focus on this side and not increase
            # however if its closer to middle + move window up, then that means our target is larger
            # and we need to move the window up
                l = m + 1 # so its farther, move window up
            else:
                r = m # else, focus on bottom half to find target
        return arr[l:l + k] # return window formed