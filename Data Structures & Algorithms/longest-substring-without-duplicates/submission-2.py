class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # given a string, find the length of the longest
        # substring without a repeating character
        # idea: we can just store everything in a set to mark it as seen, if its in
        # the set, we count as we go through the string and reset it if seen
        # each time, we have a current count and maxCount
        # this is brute force -> leads to slow time complexity
        # optimal: 

        map = {} # keep track of the most recent index seen for that character
        l, res = 0, 0
        for r in range(len(s)):
            if s[r] in map: # if the newly discovered character is in the string as we move through,
                l = max(map[s[r]] + 1, l) # we jump ahead to the index where last seen + 1, 
                # orrrr we change to l, which needs to be maxxed in order to avoid going backwards
            map[s[r]] = r # update our right, aka increase as we gp on
            res = max(res, r - l + 1) # return size of window
        return res