## 解题思路

「二分查找」是利用数组的有序性，每轮缩窄一半的查找区间（即排除一半元素），直到找到目标值或查找区间为空时返回。

由于每轮可以排除一半元素，因此查找最多循环 $\log_2 N$ 次，时间复杂度 $O(\log N)$ 。在数据量较大时，「二分查找 $O(\log N)$ 」效率大幅高于「线性查找 $O(N)$ 」。

理解二分查找的关键是理解**缩窄区间的含义**。给定升序数组 $nums$ 和目标值 $target$ ，二分查找流程如下：

1. **定义查找区间：** 初始化双指针 $i$ ,  $j$ 分别指向数组首、尾元素，代表查找区间为**闭区间** $[i, j]$ ；

2. **循环二分，缩窄查找区间：**
   
   - 使用向下取整除法，计算区间 $[i, j]$ 的中点 $m$ ；

   - 若 $nums[m] < target$ ，根据数组有序性，易得 $target$ **一定不在**闭区间 $[i, m]$ 中，因此执行 $i = m + 1$ ，即将查找区间缩窄至 $[m + 1, j]$ ；

   - 若 $nums[m] > target$ ， 根据数组有序性，易得 $target$ **一定不在**闭区间 $[m, j]$ 中，因此执行 $j = m - 1$ ，即将查找区间缩窄至 $[i, m - 1]$ ；

   - 若 $nums[m] = target$ ，说明找到 $target$ ，返回索引 $m$ 即可；

3. 不满足 $i \leq j$ 时跳出循环，此时代表无法在数组中找到 $target$ ，因此返回 $-1$ ；

![figures.gif](https://pic.leetcode-cn.com/1658569201-hBJKhZ-figures.gif)
 
动图播放较快，可以在 $\downarrow$ 一页页看

<![Slide1.png](https://pic.leetcode-cn.com/1658569199-qknEka-Slide1.png),![Slide2.png](https://pic.leetcode-cn.com/1658569199-EVIbln-Slide2.png),![Slide3.png](https://pic.leetcode-cn.com/1658569199-BdnftC-Slide3.png),![Slide4.png](https://pic.leetcode-cn.com/1658569199-nWqGUh-Slide4.png),![Slide5.png](https://pic.leetcode-cn.com/1658569199-Fjhdiu-Slide5.png),![Slide6.png](https://pic.leetcode-cn.com/1658569199-ypGHkM-Slide6.png),![Slide7.png](https://pic.leetcode-cn.com/1658569199-SKrPRX-Slide7.png),![Slide8.png](https://pic.leetcode-cn.com/1658569199-gjoVwU-Slide8.png)>

## 代码

需注意，若数组长度取值范围较大，计算中点操作 $m = \frac{i + j}{2}$ 中的 $i + j$ 可能超出 int 类型的取值范围，从而导致计算错误。此时，需使用 $m = i + \frac{j - i}{2}$ 计算中点，避免此问题。

```Python []
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] < target: i = m + 1
            elif nums[m] > target: j = m - 1
            else: return m
        return -1
```

```Java []
class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else if (nums[m] > target) j = m - 1;
            else return m;
        }
        return -1;
    }
}
```

```C++ []
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int i = 0, j = nums.size() - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else if (nums[m] > target) j = m - 1;
            else return m;
        }
        return -1;
    }
};
```

## 复杂度分析

- **时间复杂度 $O(\log N)$ ：** 其中 $N$ 为数组 $nums$ 长度。二分查找使用对数级别时间。
- **空间复杂度 $O(1)$ ：** 变量 $i$ , $j$ 使用常数大小空间。
