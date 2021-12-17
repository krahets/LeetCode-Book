'''
File: sfo_58-i_reverse_order_of_words_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()         # 删除首尾空格
        strs = s.split()      # 分割字符串
        strs.reverse()        # 翻转单词列表
        return ' '.join(strs) # 拼接为字符串并返回

# ======= Test Case =======
s = "the sky is blue"
# ====== Driver Code ======
slt = Solution()
res = slt.reverseWords(s)
print(res)
