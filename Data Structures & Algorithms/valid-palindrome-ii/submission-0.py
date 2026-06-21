class Solution:
    def validPalindrome(self, s: str) -> bool:
        # given string, return true if palindrome or can be made
        # into a palindrome after removing at most one character from it
        # idea 1: same idea as b4, create a new array and then just
        # check and if not -> recheck by removing each character and then rechecking
        # prob has a high time complexity (it does, its time complexity is O(n^2))
        # idea 2: 2 pointers, then check if the same on both ends
        # then if theres a mismatch, skip the left chaaracter and see if palindrome
        # and do the same to the right -> better, but im avoiding not making newstr bc i am lazy!

        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]: # if mismatch
                skipL = s[l + 1 : r + 1] # skip the left character
                skipR = s[l : r] # ksip right -> the syntax works splice
                # includes beginning but doesnt include ending
                return skipL == skipL[::-1] or skipR == skipR[::-1]
            l, r = l + 1, r - 1 # move inward
        return True