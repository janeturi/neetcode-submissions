class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # we can solve this via complements and hashmap :)
        # so basically. go through the array
        # and check if the complement of the current element
        # exists in the hashmap

        # if it does , return indices of the curr element and its complement
        # so we dont double log it
        # if np pair is found return empty array

        mp = {}

        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in mp:
                return [mp[complement], i]

            mp[nums[i]] = i
        return []