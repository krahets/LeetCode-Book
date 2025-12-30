"""
File: lc_151_reverse_words_in_a_string_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()         # 删除首尾空格
        strs = s.split()      # 分割字符串
        strs.reverse()        # 翻转单词列表
        return ' '.join(strs) # 拼接为字符串并返回


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.reverseWords(test_input)
print(result)
