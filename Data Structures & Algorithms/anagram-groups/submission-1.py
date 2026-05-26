class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # i had the idea to use a freq counter
        # and group strings together based off if they had the same
        # frequency, but iw asn't sure how to translate it into code!
        res = defaultdict(list) # a built in function
        # to act as our own dictionary, if it doesn't exist, make a new 
        # empty list for it
        for s in strs:
            count = [0] * 26 # each list has a potential of 26 characters from eng alphabet

            for c in s:

                count[ord(c) - ord('a')] += 1 # ascii cheatcode for counting
                # the freq in an array, ascii - 'a' neutralizes it so that order
                # doesnt change anything
                # in other words, the count for our alphabet goes up, say c is 
                # our c, then our empty freq map alphabet for c, 2 (bc we start at 0)
                # goes up, and since we're only looking at c, we will skip all the other letters
                # in the 26 we never use

            res[tuple(count)].append(s) # convert to tuple first to 
            # let us keep our count from changing across the function,
            # then append If we see an anagram of that word later, 
            # it generates the exact same signature tuple,
            # locates the existing list, and appends itself there.
        return list(res.values()) # now we returnour result list
        