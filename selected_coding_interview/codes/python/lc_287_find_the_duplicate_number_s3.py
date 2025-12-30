"""
File: lc_287_find_the_duplicate_number_s3.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        def next(i):
            return nums[i]
        slow = fast = 0
        # 第一次相遇
        while True:
            slow = next(slow)
            fast = next(next(fast))
            if slow == fast:
                break
        slow = 0
        # 第二次相遇
        while slow != fast:
            slow = next(slow)
            fast = next(fast)
        return slow


# ======= Test Case =======
test_input = [1, 3, 4, 2, 2]
expected_output = 2

# ====== Driver Code ======
slt = Solution()
result = slt.findDuplicate(test_input)
print(result)
