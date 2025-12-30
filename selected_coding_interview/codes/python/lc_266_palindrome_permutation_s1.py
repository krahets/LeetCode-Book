"""
File: lc_266_palindrome_permutation_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        dic = defaultdict(int)
        for c in s:
            dic[c] += 1
        odd = 0
        for val in dic.values():
            if val % 2 == 1:
                odd += 1
                if odd > 1:
                    return False
        return True


# ======= Test Case =======
# Test case 1
test_input = "example"

# ====== Driver Code ======
slt = Solution()
result = slt.canPermutePalindrome(test_input)
print(result)
