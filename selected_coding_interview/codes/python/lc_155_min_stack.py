"""
File: lc_155_min_stack.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []
    def push(self, x: int) -> None:
        self.stack.append(x)
        if not self.min_stack or x <= self.min_stack[-1]: 
            self.min_stack.append(x)
    def pop(self) -> None:
        if self.stack.pop() == self.min_stack[-1]:
            self.min_stack.pop()
    def top(self) -> int:
        return self.stack[-1]
    def getMin(self) -> int:
        return self.min_stack[-1]


# ======= Test Case =======
# Test case 1
operations = ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
values = [[], [-2], [0], [-3], [], [], [], []]

# ====== Driver Code ======
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print("Min:", obj.getMin())
obj.pop()
print("Top:", obj.top())
print("Min:", obj.getMin())
