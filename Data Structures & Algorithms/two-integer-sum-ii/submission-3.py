class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # nondecreasing sorted order array
        # return the indeces [1, 2] s.t. 1 + 2 = target
        # 1 != 2
        # idea, have one pointer stay still and the right pointer
        # keep moving forward until we can find one where they add up to 
        # the target, if we have gone thru all solutions
        # then move left pointer forwards and do it all again
        # nervous bc this is prob going to have a slow time complexity
        # idea2, we everythig is sorted so we can be greedy and arrange it
        # lke biggest to smallest and go inwards to find target pair?
        # refind optimal solution based off idea2: if too small, left moves up
        # if too big, move right pointer down

        l, r = 0, len(numbers) - 1
        while l < r:
            curSum = numbers[l] + numbers[r]
            if curSum > target:
                r -= 1
            elif curSum < target:
                l += 1
            else:
                return [l + 1, r + 1]
        return []