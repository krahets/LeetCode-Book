"""
File: lc_239_sliding_window_maximum_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums or k == 0: return []
        deque = collections.deque()
        # 未形成窗口
        for i in range(k):
            while deque and deque[-1] < nums[i]:
                deque.pop()
            deque.append(nums[i])
        res = [deque[0]]
        # 形成窗口后
        for i in range(k, len(nums)):
            if deque[0] == nums[i - k]:
                deque.popleft()
            while deque and deque[-1] < nums[i]:
                deque.pop()
            deque.append(nums[i])
            res.append(deque[0])
        return res


# ======= Test Case =======
test_input_nums = [1, 3, -1, -3, 5, 3, 6, 7]
test_input_k = 3
expected_output = [3, 3, 5, 5, 6, 7]

# ====== Driver Code ======
slt = Solution()
result = slt.maxSlidingWindow(test_input_nums, test_input_k)
print(result)
