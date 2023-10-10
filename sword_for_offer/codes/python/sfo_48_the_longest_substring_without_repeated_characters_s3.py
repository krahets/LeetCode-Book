'''
File: sfo_48_the_longest_substring_without_repeated_characters_s3.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic, res, i = {}, 0, -1
        for j in range(len(s)):
            if s[j] in dic:
                i = max(dic[s[j]], i) # 更新左指针 i
            dic[s[j]] = j # 哈希表记录
            res = max(res, j - i) # 更新结果
        return res

# ======= Test Case =======
s = "abcabcbb"
# ====== Driver Code ======
slt = Solution()
res = slt.lengthOfLongestSubstring(s)
print(res)
