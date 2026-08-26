class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    # given int array nums and int k, return the k most
    # freq elemenets within the array
    
    # create freq map to keep track of frequencies (if seen b4, count++)
    # add to a seperate array to sort by counts
    # then result array will only go until k

        count = {}
        for num in nums:
            count[num] = 1 + count.get(num, 0)

        arr = []
        for num, cnt in count.items():
            arr.append([cnt, num])
        arr.sort()

        res = []
        for i in range(1, k + 1):
            res.append(arr[-i][1])

        return res