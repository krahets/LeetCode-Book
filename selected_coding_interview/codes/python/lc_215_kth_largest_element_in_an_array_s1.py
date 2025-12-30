"""
File: lc_215_kth_largest_element_in_an_array_s1.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def quick_sort(nums, l, r):
            # 子数组长度为 1 时终止递归
            if l >= r: return
            # 哨兵划分操作（以 nums[l] 作为基准数）
            i, j = l, r
            while i < j:
                while i < j and nums[j] >= nums[l]: j -= 1
                while i < j and nums[i] <= nums[l]: i += 1
                nums[i], nums[j] = nums[j], nums[i]
            nums[l], nums[i] = nums[i], nums[l]
            # 递归左（右）子数组执行哨兵划分
            quick_sort(nums, l, i - 1)
            quick_sort(nums, i + 1, r)
        quick_sort(nums, 0, len(nums) - 1)
        return nums[-k]


# ======= Test Case =======
test_input_nums = [3, 2, 1, 5, 6, 4]
test_input_k = 2
expected_output = 5

# ====== Driver Code ======
slt = Solution()
result = slt.findKthLargest(test_input_nums, test_input_k)
print(result)
