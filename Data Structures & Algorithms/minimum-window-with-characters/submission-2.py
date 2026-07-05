class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # given two strings, return the shortest substring of s
        # s.t. every character w duplicates in t is also in s
        # so basicaly return only including letters that are in t
        # we can use a hashmap to track letters in both s and t, 
        # then as we go through the string, expand the window if our left 
        # pointer is in t -> problem: this doesnt return the minimum ->
        # can fix by starting to shrink from the left once we get our initial substring

        res, l = None, 0
        count, window = Counter(t), Counter() # count for t + future counter for our upcoming window       
        needed_matches = len(t) # we need all of t in our res

        for r in range(len(s)):            
            if window[s[r]] < count[s[r]]: # if our window has enough space to add additional characcters,
            # aka our substring still has remaining characters
                needed_matches -= 1
                
            window[s[r]] += 1

            if needed_matches == 0: # if we finished our substring
                while window[s[l]] > count[s[l]]: # while we have extra characters shirnk
                    window[s[l]] -= 1
                    l += 1

                if not res or (r - l + 1) < len(res): # if our first match or is actually smaller than our previous answer
                    res = s[l:r + 1] # update res
                    
        return res if res else "" # if valid widnow was found return the window if else return empty