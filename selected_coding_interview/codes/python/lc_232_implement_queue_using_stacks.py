"""
File: lc_232_implement_queue_using_stacks.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class MyQueue:
    def __init__(self):
        self.A, self.B = [], []
    def push(self, x: int) -> None:
        self.A.append(x)
    def pop(self) -> int:
        peek = self.peek()
        self.B.pop()
        return peek
    def peek(self) -> int:
        if self.B: return self.B[-1]
        if not self.A: return -1
        # 将栈 A 的元素依次移动至栈 B
        while self.A:
            self.B.append(self.A.pop())
        return self.B[-1]
    def empty(self) -> bool:
        return not self.A and not self.B


# ======= Test Case =======
# Test case 1
operations = ["MyQueue", "push", "push", "peek", "pop", "empty"]
values = [[], [1], [2], [], [], []]

# ====== Driver Code ======
obj = MyQueue()
obj.push(1)
obj.push(2)
print("Peek:", obj.peek())
print("Pop:", obj.pop())
print("Empty:", obj.empty())
