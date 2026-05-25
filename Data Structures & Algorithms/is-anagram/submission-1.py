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


