'''
File: sfo_60_probabilities_for_rolling_n_dices_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def dicesProbability(self, n: int) -> List[float]:
        dp = [1 / 6] * 6
        for i in range(2, n + 1):
            tmp = [0] * (5 * i + 1)
            for j in range(len(dp)):
                for k in range(6):
                    tmp[j + k] += dp[j] / 6
            dp = tmp
        return dp

# ======= Test Case =======
n = 2
# ====== Driver Code ======
slt = Solution()
res = slt.dicesProbability(n)
print(res)
