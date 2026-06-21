class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        # we want to reverse a string by modifyinh the array in place 
        # without using extra memory -> idea 1: swap indeces from left end to its right end counterpart until u meet in the middle
        l = 0
        r = len(s) - 1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l += 1
            r -= 1