'''
File: sfo_50_find_the_first_non-repeating_character_in_a_string_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def firstUniqChar(self, s: str) -> str:
        dic = collections.OrderedDict()
        for c in s:
            dic[c] = not c in dic
        for k, v in dic.items():
            if v: return k
        return ' '

# ======= Test Case =======
s = "abaccdeff"
# ====== Driver Code ======
slt = Solution()
res = slt.firstUniqChar(s)
print(res)
