'''
File: sfo_41_find_median_from_data_stream_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
from heapq import *

class MedianFinder:
    def __init__(self):
        self.A = [] # 小顶堆，保存较大的一半
        self.B = [] # 大顶堆，保存较小的一半

    def addNum(self, num: int) -> None:
        if len(self.A) != len(self.B):
            heappush(self.B, -heappushpop(self.A, num))
        else:
            heappush(self.A, -heappushpop(self.B, -num))

    def findMedian(self) -> float:
        return self.A[0] if len(self.A) != len(self.B) else (self.A[0] - self.B[0]) / 2.0

# ====== Driver Code ======
median_finder = MedianFinder()
res = [
    median_finder.addNum(1),
    median_finder.addNum(2),
    median_finder.findMedian(),
    median_finder.addNum(3),
    median_finder.findMedian()
]
print(res)
