"""
File: lc_242_valid_anagram_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        dic = defaultdict(int)
        for c in s:
            dic[c] += 1
        for c in t:
            dic[c] -= 1
        for val in dic.values():
            if val != 0:
                return False
        return True


# ======= Test Case =======
test_input_s = "anagram"
test_input_t = "nagaram"
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.isAnagram(test_input_s, test_input_t)
print(result)
