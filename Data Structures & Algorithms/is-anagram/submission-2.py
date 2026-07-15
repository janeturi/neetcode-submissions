class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # we can count each individual character to see if the 
        # counts are the same 
        # im using hashmap cuz i like hashmap

        if len(s) != len(t):
            return False

        countS, countT = {}, {}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            # 1 + get count for other times that letter appears
            # and if it doesnt exist return 0
            
            countT[t[i]] = 1 + countT.get(t[i], 0)
        return countS == countT

        # if len(s) != len(t):
        #    return False
##
        #count = [0] * 26
        #for i in range(len(s)):
        #    count[ord(s[i]) - ord('a')] += 1
        #    count[ord(t[i]) - ord('a')] -= 1

        #for val in count:
        #    if val != 0:
        #        return False
        #return True

        # -> in this method, we compare values of both strings and if the values differ,
        # then we know our anagrams are not the same
