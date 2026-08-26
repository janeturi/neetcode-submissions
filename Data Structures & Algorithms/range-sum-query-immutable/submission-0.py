class NumArray:
    # optimized:
    # idea is that we use right boundary - sum of prefix to get our answer
    def __init__(self, nums: List[int]):
        self.prefix = [0] * (len(nums) + 1)
        for i in range(len(nums)):
            self.prefix[i + 1] = self.prefix[i] + nums[i] # every next number's prefix is the sum of current num + what we already summed 

    def sumRange(self, left: int, right: int) -> int:
        return self.prefix[right + 1] - self.prefix[left] # sum of right - sum b4 left

    # my first ver: good but slow
    #  def __init__(self, nums: List[int]):
     #   self.nums = nums

    #def sumRange(self, left: int, right: int) -> int:
     #   res = 0
     #   for i in range(left, right + 1):
      #      res += self.nums[i]
       # return res

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)