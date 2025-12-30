"""
File: lc_946_validate_stack_sequences.py
Created Time: 2025-12-30
Author: krahets
"""

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
test_input_pushed = [1, 2, 3, 4, 5]
test_input_popped = [4, 5, 3, 2, 1]
expected_output = True

# ====== Driver Code ======
slt = Solution()
result = slt.validateStackSequences(test_input_pushed, test_input_popped)
print(result)
