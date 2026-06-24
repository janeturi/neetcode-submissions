class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # given two int arrays in sorted order, merge both arrays
        # into one that is also in sorted order

        #idea 1: since we know both are sorted, we can plug in the second array
        # and then resort -> probably bad time complexity
        # idea 2: we can have two pointers for nums1 and nums2. the biggest number goes at
        # the very end of nums1 and we keep moving downwards unyil we finish nums2
        last = m + n - 1 
        i, j = m - 1, n - 1 # pointers
        while j >= 0: # while nums 2 has remaining nums (we still have unsorted nums)
            if i >= 0 and nums1[i] > nums2[j]: # nums is bigger
                nums1[last] = nums1[i] # biggest number is in nums1
                i -= 1 # move down
            else:
                nums1[last] = nums2[j] # biggest number is in nums2
                j -= 1
            last -= 1 #keep going down