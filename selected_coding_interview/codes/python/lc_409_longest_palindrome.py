"""
File: lc_409_longest_palindrome.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def longestPalindrome(self, s: str) -> int:
        # 统计各字符数量
        counter = collections.defaultdict(int)
        for c in s:
            counter[c] += 1
        res, odd = 0, 0
        # 统计构造回文串的最大长度
        for count in counter.values():
            # 将当前字符出现次数向下取偶数，并计入 res
            rem = count % 2
            res += count - rem
            # 若当前字符出现次数为奇数，则将 odd 置 1
            if rem == 1: odd = 1
        return res + odd


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.longestPalindrome(test_input)
print(result)
