'''
File: sfo_59-ii_max_queue_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
import queue

class MaxQueue:
    def __init__(self):
        self.queue = queue.Queue()
        self.deque = queue.deque()

    def max_value(self) -> int:
        return self.deque[0] if self.deque else -1

    def push_back(self, value: int) -> None:
        self.queue.put(value)
        while self.deque and self.deque[-1] < value:
            self.deque.pop()
        self.deque.append(value)

    def pop_front(self) -> int:
        if self.queue.empty(): return -1
        val = self.queue.get()
        if val == self.deque[0]:
            self.deque.popleft()
        return val

# ====== Driver Code ======
max_queue = MaxQueue()
res = [
    max_queue.push_back(1),
    max_queue.push_back(2),
    max_queue.max_value(),
    max_queue.pop_front(),
    max_queue.max_value()
]
print(res)
