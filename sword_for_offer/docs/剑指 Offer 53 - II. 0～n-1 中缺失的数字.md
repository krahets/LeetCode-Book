## 解题思路：

排序数组中的搜索问题，首先想到 **二分法** 解决。根据题意，数组可以按照以下规则划分为两部分。

- **左子数组：** $nums[i] = i$ ；
- **右子数组：** $nums[i] \ne i$ ；

缺失的数字等于 **“右子数组的首位元素”** 对应的索引；因此考虑使用二分法查找 “右子数组的首位元素” 。

![Picture1.png](https://pic.leetcode-cn.com/1600794300-lLZwAz-Picture1.png){:width=500}

### 算法解析：

1. **初始化：** 左边界 $i = 0$ ，右边界 $j = len(nums) - 1$ ；代表闭区间 $[i, j]$ 。
2. **循环二分：** 当 $i \leq j$ 时循环 *（即当闭区间 $[i, j]$ 为空时跳出）* ；
   1. 计算中点 $m = (i + j) // 2$ ，其中 "$//$" 为向下取整除法；
   2. 若 $nums[m] = m$ ，则 “右子数组的首位元素” 一定在闭区间 $[m + 1, j]$ 中，因此执行 $i = m + 1$；
   3. 若 $nums[m] \ne m$ ，则 “左子数组的末位元素” 一定在闭区间 $[i, m - 1]$ 中，因此执行 $j = m - 1$；
3. **返回值：** 跳出时，变量 $i$ 和 $j$ 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 $i$ 即可。

<![Picture2.png](https://pic.leetcode-cn.com/1600794300-qbJfal-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1600794300-VjhSkK-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1600794300-FMaRIx-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1600794300-GXuUPk-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1600794300-FmuzzQ-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1600794300-KnWTTf-Picture7.png)>

### 复杂度分析：

- **时间复杂度 $O(\log N)$：** 二分法为对数级别复杂度。
- **空间复杂度 $O(1)$：** 几个变量使用常数大小的额外空间。

## 代码：

```Python []
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] == m: i = m + 1
            else: j = m - 1
        return i
```

```Java []
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
```

```C++ []
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int i = 0, j = nums.size() - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
};
```
