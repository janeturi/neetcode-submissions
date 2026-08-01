class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # given integers and int k, there's a sliding window of size k
        # starting at l, moving forward until it reaches k 
        # return list that contains the ma element in window at each step
        # idea1: just move forward with size k window and add max() element to res
        # -> slow time complexity
        # idea2: we can use a maxheap that after k deques, returns the top element which shold be the max
        # -> slowish time compelxity bc we keep our 'old' elements stored in our heap
        # optimal: use a deque to store indeces of elements in decreasing order of values
        # front holds max, then remove the minimum each time we push a new number 
        # + we can easily remove max too if its not in window anymroe

        output = []
        q = deque() # our queue to find max, will not necessarily be size k
        l = r = 0

        while r < len(nums):
            while q and nums[q[-1]] < nums[r]: #each time we add a 
            # new element, remove all the elements smaller than the new one v
                q.pop()
            q.append(r) # even if our new right is the smallest, we will still add it to our queue bc it will automatically be placed at the back bc it is a queue, so since our max is at the front, we can still return it

            if l > q[0]: #if the index of our left boundary is furhter than our max in our queue
                q.popleft() # we are forced to remove it bc it's invalid (eldest at front of queue)

            if (r + 1) >= k: # once we've PROCESSED at least k elements, we can pop our max
                output.append(nums[q[0]]) # 
                l += 1 # move forward

            r += 1# move forward
        return output
