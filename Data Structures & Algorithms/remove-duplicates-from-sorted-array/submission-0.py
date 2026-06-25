class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # given a sorted array, remove duplciates in place 
        # then return number of unique elements
        # elements that are sorted and are duplicates mean
        # that we can have two pointers or something that we can check
        # if our nums are the same
        # if so, swap with the nums outside of the k bounds ? or get rid of it by overwriting
        # to avoid space wasting
        l = 1 # first element cant be a duplicate
        for r in range(1, len(nums)):
            if nums[r] != nums[r - 1]: # as we move through, does the number match w the one before it?
                nums[l] = nums[r] # if not, this means they aren't a duplicate of eachother, 
                # so we move along but we overwrite our irght pointer
                # wiht our left so that we can "push out" the duplicates 
                l += 1 # so move on, we dont do anything
        return l