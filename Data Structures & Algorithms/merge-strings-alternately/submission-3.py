class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        # draft:
        # res = []
        #i = 0
        #while i < len(word1) and i < len(word2):
        #    res.append(word1[i])
        #    res.append(word2[i])
        #    i += 1
        
        #for j in range(i, len(word1)):
        #    res.append(word1[j])
        
        #for j in range(i, len(word2)):
        #    res.append(word2[j])
        
        #return "".join(res)
        # slow, could be more efficient

        # this method is basically the same but written in a better way:
        n, m = len(word1), len(word2)
        res = []
        for i in range(max(m, n)):
            if i < n:
                res.append(word1[i])
            if i < m:
                res.append(word2[i])
        return "".join(res)