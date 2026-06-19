class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # given an array of integers nums and int k 
        # return the total # of subarrays whose sum equals k
        # aka non empty seq of elements wiwthin array
        # idea 1: sliding window approach? keep adding for as long
        # as we have not gone over the sum, end and add to res once it is reached
        # sequences end once == k (which add to res) or > k
        # works but -> leads to O(n^2), optimal implementation below

        # instead, we can use hashmap to lookup values easier
        # we will notice that each new subarray has a difference of k
        # with the last subarray, so if the last subarray = k, then
        # that means sum - k is present in another array which can be found and matched
        # using the hashmap

        
        prefixSum = defaultdict(int)
        prefixSum[0] = 1
        curr = 0
        total = 0

        for num in nums: # build hashmap
            curr += num # add num to current sum
            total += prefixSum[curr - k] # check if current - k exists, if so, add to number of matches
            prefixSum[curr] += 1 # this marks our position, so for each number and lookup, we can
            # also continuously mark previously used sequences and use it in our total
            # basically, prefixSum is used as our current, changing, number of sequences
            # but total is our actual final answer 
        return total