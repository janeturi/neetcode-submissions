class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # given nums and k, return true if there are two same numbers 
        # that are the same value and also abs(i - j) <= k
        # idea: our window can start being fixed at size k, then use a window
        # to see if we can find a duplicate in it using a hashset for quick lookup
        # if not, move our window forward 
        window = set()
        l = 0
        for r in range(len(nums)):
            if r - l > k: # if our window size is too big bc we kept adding our right
                window.remove(nums[l]) # adjust window and move leftmost
                l += 1
            if nums[r] in window: # if duplicate found in our window of size k
                return True
            window.add(nums[r]) # mark r as seen so we dont keep checking for it
        
        return False
