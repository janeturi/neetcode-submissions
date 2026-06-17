class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        # return the length of the longest seq in which
        # each element is exactly 1 greater than the prev

        # make a map of each number and then go through the array
        # then make a hashmap and if + 1 is in the map, then loop
        # and repeat until the cycle breaks. also + count??
        # -> would take too long
        # make a set to attach longest length
        # w the current num and if num - 1 doesnt exist its length is 1
        # bc the seq has just started
        #


        numSet = set(nums)
        longest = 0 
        for num in numSet:
            if (num - 1) not in numSet: # if a new seq started
                length = 1 # reset length count
                while (num + length) in numSet: # as long as it exists in the og set
                    length += 1 # length continues to increase
                longest = max(length, longest) # longest is max
        return longest