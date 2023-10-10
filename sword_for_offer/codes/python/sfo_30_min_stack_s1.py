'''
File: sfo_30_min_stack_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class MinStack:
    def __init__(self):
        self.A, self.B = [], []

    def push(self, x: int) -> None:
        self.A.append(x)
        if not self.B or self.B[-1] >= x:
            self.B.append(x)

    def pop(self) -> None:
        if self.A.pop() == self.B[-1]:
            self.B.pop()

    def top(self) -> int:
        return self.A[-1]

    def min(self) -> int:
        return self.B[-1]

# ====== Driver Code ======
min_stack = MinStack()
res = [
    min_stack.push(-2),
    min_stack.push(0),
    min_stack.push(-3),
    min_stack.min(),
    min_stack.pop(),
    min_stack.top(),
    min_stack.min()
]
print(res)
