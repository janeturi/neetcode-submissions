class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # given a string of uppercase characters and k, 
        # after k replacements, retunr length of the longest substring w only one 
        # unique character

        # idea: use a frequency map because non frequent ones
        # should get replaced to avoid using up k's and increase chance of 
        # having a long seq

        # for future problems:
        # - "after k replacements" -> budget sliding window
        # usually needs a TRACKER -> frequency: keep track of things, counter, sum etc
        count = {}
        res, l, maxf = 0, 0, 0
        for r in range(len(s)):
            count[s[r]] = 1 + count.get(s[r], 0) # count goes up for each character, but we keep track of
            # whatever character is the highest.
            maxf = max(maxf, count[s[r]]) # maxf is our max frequency of a character as it grows,
            while (r - l + 1) - maxf > k: # when we need to replace more characters than allowed, we move our window
            # to test other combos
                count[s[l]] -= 1 # decrease count in window
                l += 1 # move pointer
            res = max(res, r - l + 1) # our result will be the largest valid window
        return res