class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        # given int array where indeces determine weight of a person
        # + inifnite # of boats, each boat carries max 2 ppl at same time 
        # so the sum <= limit
        # idea 1: sort array, then try to pair the heaviest with lightest 
        # continuously -> if our heaviest = limit, or no viable solution, we return
        # the heaviest alone. if we have extra space, we can use a heavier person instead
        # so move left pointer up 
        people.sort()
        res, l, r = 0, 0, len(people) - 1
        while l <= r:
            if people[l] + people[r] <= limit:
                l += 1
            r -= 1
            res += 1 # always goes up bc right pointer always gets a boat
        return res