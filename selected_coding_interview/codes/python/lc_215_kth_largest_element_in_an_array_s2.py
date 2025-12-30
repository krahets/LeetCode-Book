"""
File: lc_215_kth_largest_element_in_an_array_s2.py
Created Time: 2025-12-30
Author: krahets
"""

from include import *


# ===== Solution Code =====
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def quick_sort(l, r):
            i, j = l, r
            while i < j:
                while i < j and nums[j] >= nums[l]: j -= 1
                while i < j and nums[i] <= nums[l]: i += 1
                nums[i], nums[j] = nums[j], nums[i]
            nums[l], nums[i] = nums[i], nums[l]
            if i > len(nums) - k: return quick_sort(l, i - 1) 
            if i < len(nums) - k: return quick_sort(i + 1, r)
            # 若基准数索引为 n - k ，则直接返回该元素
            return nums[-k]
        return quick_sort(0, len(nums) - 1)


# ======= Test Case =======
test_input_nums = [3, 2, 1, 5, 6, 4]
test_input_k = 2
expected_output = 5

# ====== Driver Code ======
slt = Solution()
result = slt.findKthLargest(test_input_nums, test_input_k)
print(result)
