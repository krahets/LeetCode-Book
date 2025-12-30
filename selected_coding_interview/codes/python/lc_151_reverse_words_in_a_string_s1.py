"""
File: lc_151_reverse_words_in_a_string_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()                            # 删除首尾空格
        i = j = len(s) - 1
        res = []
        while i >= 0:
            while i >= 0 and s[i] != ' ': i -= 1 # 搜索首个空格
            res.append(s[i + 1: j + 1])          # 添加单词
            while i >= 0 and s[i] == ' ': i -= 1 # 跳过单词间空格
            j = i                                # j 指向下个单词的尾字符
        return ' '.join(res)                     # 拼接并返回


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.reverseWords(test_input)
print(result)
