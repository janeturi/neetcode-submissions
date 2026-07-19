class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # given two strings, return the shortest substring of s
        # s.t. every character w duplicates in t is also in s
        # so basicaly return only including letters that are in t
        # we can use a hashmap to track letters in t, 
        # then as we go through the string, expand the window if our left 
        # pointer is in t -> problem: this doesnt return the minimum ->
        # can fix by starting to shrink from the left once we get our initial substring

        res, l = None, 0
        cnt, window = Counter(t), Counter() # count for our string and countfor our windows since t is our 'main' string
        # and s is our secondary string
        
        for r in range(len(s)): 
            window[s[r]] += 1 # as we go through, count the frequency of each indiv character in our window
            
            if window >= cnt: # if our window's counts are the minimum to be valid
                while window[s[l]] > cnt[s[l]]: # check if we have more to spare
                    window[s[l]] -= 1 # if yes reduce count and move to minimize our window
                    l += 1

                if not res or (r - l + 1) < len(res): # if not empty or we found a smaller res, we update
                    res = s[l:r + 1]
        return res if res else "" # return res if window fount return empty if no valid substring