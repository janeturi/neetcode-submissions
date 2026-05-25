class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # my idea was to use a hash map to look at whatever has a count
        # more than 1 -> which works! but maps are slwoer than hash sets

        seen = set()
        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        return False