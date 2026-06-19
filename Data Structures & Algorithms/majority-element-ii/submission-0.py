class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        # given int array nums of size n
        # 1st idea: find lal elements appearing more than n/3 times
        # we can keep track of all the elements by sorting
        # by value and and then take the longest sequence 
        # -> but this would only return 1 number, but there can
        # be multiple
        # so 2nd idea: split len(nums)/3 and return all the numbers
        # that have > length by adding them to a set
        # -> works but big space complexty

        count = Counter(nums)
        res = []

        for key in count:
            if count[key] > len(nums) // 3:
                res.append(key)

        return res