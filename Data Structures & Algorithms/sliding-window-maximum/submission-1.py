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
        q = deque()
        l = r = 0

        while r < len(nums):
            while q and nums[q[-1]] < nums[r]: # remove value at the bottom eah time we push an element
            # bc no reason to have small elements in q since it wont be the max
                q.pop()
            q.append(r) # add our right element if it is bigger than element at bottom

            if l > q[0]: # if left pointer is > index of at the top than we remove the queue's element
            # bc its no longer apart of the window
                q.popleft()

            if (r + 1) >= k: # window reaches size k
                output.append(nums[q[0]]) # our max is the front of dq
                l += 1 # move forward
            r += 1# move forward
        return output