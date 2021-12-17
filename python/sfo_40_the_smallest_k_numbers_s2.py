'''
File: sfo_40_the_smallest_k_numbers_s2.py
Created Time: 2021-12-09
Author: Krahets (krahets@163.com)
'''

from include import *

# ===== Solution Code =====
class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        if k >= len(arr): return arr
        def quick_sort(l, r):
            i, j = l, r
            while i < j:
                while i < j and arr[j] >= arr[l]: j -= 1
                while i < j and arr[i] <= arr[l]: i += 1
                arr[i], arr[j] = arr[j], arr[i]
            arr[l], arr[i] = arr[i], arr[l]
            if k < i: return quick_sort(l, i - 1) 
            if k > i: return quick_sort(i + 1, r)
            return arr[:k]
            
        return quick_sort(0, len(arr) - 1)

# ======= Test Case =======
arr = [3, 2, 1]
k = 2
# ====== Driver Code ======
slt = Solution()
res = slt.getLeastNumbers(arr, k)
print(res)
