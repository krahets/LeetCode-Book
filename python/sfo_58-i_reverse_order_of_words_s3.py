'''
File: sfo_58-i_reverse_order_of_words_s3.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(s.strip().split()[::-1])

# ======= Test Case =======
s = "the sky is blue"
# ====== Driver Code ======
slt = Solution()
res = slt.reverseWords(s)
print(res)
