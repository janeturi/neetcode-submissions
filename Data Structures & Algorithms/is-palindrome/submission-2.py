class Solution:
    def isPalindrome(self, s: str) -> bool:
        # return true if a string is a palindrome
        # otherwise return false

        # we can do two poiners and have one going forward and one backward,
        # then check if they're the same, return false if no
        # SHOULD work, but this ignores spaces and non-alphanumeric stuff 
        # we can apply the same logic but handle the non alphanumeric stuff in a diff function
        
        #idea 2: just make a new string ignoring everything else and then 
        # check if its the same reversed

        newStr = ''
        for c in s:
            if c.isalnum():
                newStr += c.lower()
        return newStr == newStr[::-1]