'''
File: sfo_63_the_maximum_profit_of_stocks_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cost, profit = float("+inf"), 0
        for price in prices:
            cost = min(cost, price)
            profit = max(profit, price - cost)
        return profit

# ======= Test Case =======
prices = [7, 1, 5, 3, 6, 4]
# ====== Driver Code ======
slt = Solution()
res = slt.maxProfit(prices)
print(res)
