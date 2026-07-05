class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # given two strings, return true if s2 contains same letters as s1 
        # in a seq, order doesnt matter 
        # i think we can first use a frequency counter?? to check if we have the same frequencies
        # in both strings and if yes then we can go ahead....?? then use that
        # and a sliding window somehow to check if the frequencies match up w s1 in s2

        freq = Counter(s1) # count our s1
        count = defaultdict(int) # build our hashmap

        l = 0
        for r in range(len(s2)):
            count[s2[r]] += 1 # add s2 to hashmap 

            if (r - l + 1) > len(s1): # we shrink our window if our window is bigger than s1
                count[s2[l]] -= 1 # then our count for s2 goes down
                if count[s2[l]] == 0: # remove from dict if our count goes to 0, !python thing!
                    del count[s2[l]] 
                l += 1
            
            if count == freq: # if values are same..
                return True # return true

        return False
