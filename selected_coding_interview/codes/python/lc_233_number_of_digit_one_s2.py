"""
File: lc_233_number_of_digit_one_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def countDigitOne(self, n: int) -> int:
        digit, res = 1, 0
        high, cur, low = n // 10, n % 10, 0
        while high != 0 or cur != 0: # 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
            if cur == 0: res += high * digit
            elif cur == 1: res += high * digit + low + 1
            else: res += (high + 1) * digit
            low += cur * digit # 将 cur 加入 low ，组成下轮 low
            cur = high % 10 # 下轮 cur 是本轮 high 的最低位
            high //= 10 # 将本轮 high 最低位删除，得到下轮 high
            digit *= 10 # 位因子每轮 × 10
        return res


# ======= Test Case =======
test_input = 12
expected_output = 5

# ====== Driver Code ======
slt = Solution()
result = slt.countDigitOne(test_input)
print(result)
