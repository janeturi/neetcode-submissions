class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        # merge two strings by alternating order from str1 to str2
        # idea 1: have two pointers for both strings, goign forward
        # each time at the same time for both and we just add like that
        # + handle missing characters if we still havent reached the end of the 
        # word and there are still more left in the other 
        n, m = len(word1), len(word2)
        res = []
        i = j = 0
        while i < n or j < m: 
            if i < n: # if we havent reached end yet, add
                res.append(word1[i])
            if j < m: # ^
                res.append(word2[j])
            i += 1 # move pointer
            j += 1
        return "".join(res) # add to empty res