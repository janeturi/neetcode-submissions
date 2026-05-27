class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # given array of strings strs retunrn the longest 
        # common prefix of all 
        # if dne, return empty string ""

        # frequency counts wouldn't work
        # can sort by ascii stuff and then do windows until it starts to differ?

        if len(strs) == 1:
            return strs[0] # if length = 1 then strs is that string

        strs = sorted(strs) # sort
        for i in range(min(len(strs[0]), len(strs[-1]))): # compare first and last strings in the sorted array
        # aka create a window that increases for each for loop pass
            if strs[0][i] != strs[-1][i]: # once they differ
                return strs[0][:i] # the string breaks apart
                # :i breaks and returns the first i characters in the string (like substring)
        return strs[0]