class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # given integer array prices where prices[i] is price of 
        # stock on the ith day

        # return max profit if also allowed to buy and sell on the same
        # day but only hold at most one share of stock

        # cant i just pass through it twice and choose smallest int to buy 
        # and then sell it on biggest?i  think not that easy bc 
        # biggest needs to go after.
        # maybe we do it by pairs and decide whether to buy or sell
        # based on the biggest/smallest in pair?

        profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]: # if the current one is better
            # than previous one then there is a profit
            # so 
                profit += (prices[i] - prices[i - 1]) # we add that profit
                # to the profit we have already chosen from before
        return profit