"""
File: lc_239_sliding_window_maximum_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        deque = collections.deque()
        res, n = [], len(nums)
        for i, j in zip(range(1 - k, n + 1 - k), range(n)):
            # 删除 deque 中对应的 nums[i-1]
            if i > 0 and deque[0] == nums[i - 1]:
                deque.popleft()
            # 保持 deque 递减
            while deque and deque[-1] < nums[j]:
                deque.pop()
            deque.append(nums[j])
            # 记录窗口最大值
            if i >= 0:
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
