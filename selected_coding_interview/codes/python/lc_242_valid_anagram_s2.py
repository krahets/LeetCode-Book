"""
File: lc_242_valid_anagram_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 若 s, t 长度不同，则不互为重排
        if len(s) != len(t):
            return False
        # 初始化字典 dic ，且所有 key 的初始 value 都为 0
        dic = defaultdict(int)
        # 统计字符串 s 各字符数量，遇到 +1
        for c in s:
            dic[c] += 1
        # 统计字符串 t 各字符数量，遇到 -1
        for c in t:
            dic[c] -= 1
        # 遍历 s, t 中各字符的数量差
        for val in dic.values():
            # 若 s, t 中某字符的数量不一致，则不互为重排
            if val != 0:
                return False
        # 所有字符数量都一致，因此互为重排
        return True


# ======= Test Case =======
test_input_s = "anagram"
test_input_t = "nagaram"
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.isAnagram(test_input_s, test_input_t)
print(result)
