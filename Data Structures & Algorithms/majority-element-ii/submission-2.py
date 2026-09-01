class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        # given int array nums of size n
        # first idea: use python count function add all elements that 
        # have a count greater than len(nums) // 3 -> works, slow -> use counter instead

        count = Counter(nums)
        res = []

        for key in count:
            if count[key] > len(nums) // 3:
                res.append(key)

        return res