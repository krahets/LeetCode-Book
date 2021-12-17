'''
File: sfo_56-ii_single_number_ii_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        counts = [0] * 32
        for num in nums:
            for i in range(32):
                counts[i] += num & 1 # 更新第 i 位 1 的个数之和
                num >>= 1            # 第 i 位 --> 第 i 位
        res, m = 0, 3
        for i in range(31, -1, -1):
            res <<= 1
            res |= counts[i] % m     # 恢复第 i 位
        return res if counts[31] % m == 0 else ~(res ^ 0xffffffff)

# ======= Test Case =======
nums = [3, 4, 3, 3]
# ====== Driver Code ======
slt = Solution()
res = slt.singleNumber(nums)
print(res)
