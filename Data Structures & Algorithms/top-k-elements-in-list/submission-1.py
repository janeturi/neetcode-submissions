class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    # given int array nums and int k, return the k most
    # freq elemenets within the array
    
    # create freq map to keep track of frequencies (if seen b4, count++)
    # we use a minheap because it keeps smallest elements at the top !!
    # we ensure that we dont return any other elements beyond size k
    # by popping whenever k is reached
        count = {} 
        for num in nums: 
            count[num] = 1 + count.get(num, 0) # count for each number
            # goes up by 1 initially + the amount of times its listed in num

        heap = []
        for num in count.keys():
            heapq.heappush(heap, (count[num], num)) # push regular heap and 
            # the freq + number into the min heap
            # heappush takes in (heap, item) and we're pushing the freq + num as the item
            if len(heap) > k:
                heapq.heappop(heap) # pop the infrequent elements one size k is reached

        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1]) # now that we only have k, we
            # can push in the k elements into the res bc the only ones not popped
            # are the more frequent ones bc the less freq ones have already been popped
            # [1] isolates the number from (count, num)
        return res
                