'''
File: sfo_19_regular_expression_matching_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s) + 1, len(p) + 1
        dp = [[False] * n for _ in range(m)]
        dp[0][0] = True
        # 初始化首行
        for j in range(2, n, 2):
            dp[0][j] = dp[0][j - 2] and p[j - 1] == '*'
        # 状态转移
        for i in range(1, m):
            for j in range(1, n):
                if p[j - 1] == '*':
                    if dp[i][j - 2]: dp[i][j] = True                              # 1.
                    elif dp[i - 1][j] and s[i - 1] == p[j - 2]: dp[i][j] = True   # 2.
                    elif dp[i - 1][j] and p[j - 2] == '.': dp[i][j] = True        # 3.
                else:
                    if dp[i - 1][j - 1] and s[i - 1] == p[j - 1]: dp[i][j] = True # 1.
                    elif dp[i - 1][j - 1] and p[j - 1] == '.': dp[i][j] = True    # 2.
        return dp[-1][-1]

# ======= Test Case =======
s = "mississippi"
p = "mis*is*p*."
# ====== Driver Code ======
slt = Solution()
res = slt.isMatch(s, p)
print(res)
