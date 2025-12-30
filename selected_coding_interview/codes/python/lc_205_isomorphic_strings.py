"""
File: lc_205_isomorphic_strings.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s2t, t2s = {}, {}
        for a, b in zip(s, t):
            # 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            # 说明有一对多的映射关系，则返回 false ；
            # 对于映射 b -> a 也同理
            if a in s2t and s2t[a] != b or \
               b in t2s and t2s[b] != a:
                return False
            s2t[a], t2s[b] = b, a
        return True


# ======= Test Case =======
test_input_s = "egg"
test_input_t = "add"
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.isIsomorphic(test_input_s, test_input_t)
print(result)
