'''
File: sfo_40_the_smallest_k_numbers_s1.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        def quick_sort(arr, l, r):
            # 子数组长度为 1 时终止递归
            if l >= r: return
            # 哨兵划分操作（以 arr[l] 作为基准数）
            i, j = l, r
            while i < j:
                while i < j and arr[j] >= arr[l]: j -= 1
                while i < j and arr[i] <= arr[l]: i += 1
                arr[i], arr[j] = arr[j], arr[i]
            arr[l], arr[i] = arr[i], arr[l]
            # 递归左（右）子数组执行哨兵划分
            quick_sort(arr, l, i - 1)
            quick_sort(arr, i + 1, r)
        
        quick_sort(arr, 0, len(arr) - 1)
        return arr[:k]

# ======= Test Case =======
arr = [3, 2, 1]
k = 2
# ====== Driver Code ======
slt = Solution()
res = slt.getLeastNumbers(arr, k)
print(res)
