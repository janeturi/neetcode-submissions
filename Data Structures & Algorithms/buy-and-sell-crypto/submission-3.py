class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # given prices, you may choose a single day to buy oen neetcoin
        # and choose a diff day in the FUTURE to sell.
        # return max profit possible
        # idea1: we know that the max profit would likely
        # be whwere we can buy for least amount and sell for largest we can go through everything once and continuously try to see
        # if we override minBuy and maxProfit. -> nervous it won't handle the maxSell coming before minBuy
        maxProfit, minBuy = 0, prices[0] # minBuy is our first price
        for sell in prices: 
            maxProfit = max(maxProfit, sell - minBuy) 
            minBuy = min(minBuy, sell)
        return maxProfit