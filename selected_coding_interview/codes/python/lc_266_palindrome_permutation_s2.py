"""
File: lc_266_palindrome_permutation_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        # 初始化哈希表
        dic = defaultdict(int)
        # 统计字符串中各字符的数量
        for c in s:
            dic[c] += 1
        odd = 0
        for val in dic.values():
            # 统计“数量为奇数”字符的个数
            if val % 2 == 1:
                odd += 1
                # 若“数量为奇数”的字符个数 > 1 ，则不是回文串排列
                if odd > 1:
                    return False
        # 若“数量为奇数”的字符个数 <= 1 ，则是回文串排列
        return True


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.canPermutePalindrome(test_input)
print(result)
