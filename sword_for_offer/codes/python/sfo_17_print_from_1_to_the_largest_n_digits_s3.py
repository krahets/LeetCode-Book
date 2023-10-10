'''
File: sfo_17_print_from_1_to_the_largest_n_digits_s3.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def printNumbers(self, n: int) -> List[int]:
        def dfs(x):
            if x == n:
                s = ''.join(num[self.start:])
                if s != '0': res.append(s)
                if n - self.start == self.nine: self.start -= 1
                return
            for i in range(10):
                if i == 9: self.nine += 1
                num[x] = str(i)
                dfs(x + 1)
            self.nine -= 1
        
        num, res = ['0'] * n, []
        self.nine = 0
        self.start = n - 1
        dfs(0)
        return ','.join(res)

# ======= Test Case =======
n = 1
# ====== Driver Code ======
slt = Solution()
res = slt.printNumbers(n)
print(res)
