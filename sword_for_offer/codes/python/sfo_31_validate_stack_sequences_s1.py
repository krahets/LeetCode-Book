'''
File: sfo_31_validate_stack_sequences_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack, i = [], 0
        for num in pushed:
            stack.append(num) # num 入栈
            while stack and stack[-1] == popped[i]: # 循环判断与出栈
                stack.pop()
                i += 1
        return not stack

# ======= Test Case =======
pushed = [1, 2, 3, 4, 5]
popped = [4, 5, 3, 2, 1]
# ====== Driver Code ======
slt = Solution()
res = slt.validateStackSequences(pushed, popped)
print(res)
