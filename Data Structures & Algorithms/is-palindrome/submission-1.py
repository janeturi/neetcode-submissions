class Solution:
    def isPalindrome(self, s: str) -> bool:
        # return true if a string is a palindrome
        # otherwise return false

        # we can do two poiners and have one going forward and one backward,
        # then check if they're the same, return false if no
        # SHOULD work, but this ignores spaces and non-alphanumeric stuff 
        # we can apply the same logic but handle the non alphanumeric stuff in a diff function
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not self.alphaNum(s[l]):
                l += 1
            while r > l and not self.alphaNum(s[r]):
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l, r = l + 1, r - 1
        return True
    
    def alphaNum(self, c):
        return(ord('A') <= ord(c) <= ord('Z') or 
        ord('a') <= ord(c) <= ord('z') or 
        ord('0') <= ord(c) <= ord('9'))