## 解题思路

题目仅说明是整数数组，无其他已知条件，因此考虑直接遍历数组。

- 设索引 $i$ 对应变量「左侧元素相加和 `sum_left` 」和「右侧元素相加和 `sum_right` 」。
- 遍历数组 `nums` ，每轮更新  `sum_left` 和 `sum_right` 。
- 遍历中，遇到满足 `sum_left == sum_right` 时，说明当前索引为中心下标，返回即可。
- 若遍历完成，仍未找到「中心下标」，则返回 -1 。

初始化时，相当于索引 $i = - 1$ ，此时 `sum_left = 0` , `sum_right = 所有元素的和` 。

> 首页为动态图，其余页为静态图，方便一步步看。

<![figures.gif](https://pic.leetcode-cn.com/1656947339-ObGLSz-figures.gif),![Slide1.png](https://pic.leetcode-cn.com/1656947327-uimVQE-Slide1.png),![Slide2.png](https://pic.leetcode-cn.com/1656947327-VMOUZe-Slide2.png),![Slide3.png](https://pic.leetcode-cn.com/1656947327-VFdSRK-Slide3.png),![Slide4.png](https://pic.leetcode-cn.com/1656947327-GnULkl-Slide4.png),![Slide5.png](https://pic.leetcode-cn.com/1656947327-zHMopP-Slide5.png),![Slide6.png](https://pic.leetcode-cn.com/1656947327-kcIwKf-Slide6.png),![Slide7.png](https://pic.leetcode-cn.com/1656947327-QwsXsh-Slide7.png),![Slide8.png](https://pic.leetcode-cn.com/1656947327-dUmJJD-Slide8.png),![Slide9.png](https://pic.leetcode-cn.com/1656947327-VtWUbt-Slide9.png),![Slide10.png](https://pic.leetcode-cn.com/1656947327-TZmGbu-Slide10.png),![Slide11.png](https://pic.leetcode-cn.com/1656947327-tOkBmU-Slide11.png),![Slide12.png](https://pic.leetcode-cn.com/1656947327-ehfZIF-Slide12.png),![Slide13.png](https://pic.leetcode-cn.com/1656947327-WRWlDN-Slide13.png),![Slide14.png](https://pic.leetcode-cn.com/1656947327-avGuPo-Slide14.png)>

## 代码

需要考虑大数越界问题。题目给定整数数组 `nums` ，并给定取值范围。

$$
1 \leq nums.length \leq 10^4 \\
-1000 \leq nums[i] \leq 1000
$$

易得「元素相加和」的取值范围为 $[-10^7, 10^7]$ ，在 `int` 类型的取值范围内，因此 `sum_left` 和 `sum_right` 使用 int 类型即可。

```Python []
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        sum_left, sum_right = 0, sum(nums)
        for i in range(len(nums)):
            sum_right -= nums[i]
            # 若左侧元素和等于右侧元素和，返回中心下标 i
            if sum_left == sum_right:
                return i
            sum_left += nums[i]
        return -1
```

```Java []
class Solution {
    public int pivotIndex(int[] nums) {
        int sumLeft = 0, sumRight = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            sumRight -= nums[i];
            // 若左侧元素和等于右侧元素和，返回中心下标 i
            if (sumLeft == sumRight)
                return i;
            sumLeft += nums[i];
        }
        return -1;
    }
}
```

```C++ []
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int sumLeft = 0, sumRight = accumulate(nums.begin(), nums.end(), 0);
        for (int i = 0; i < nums.size(); i++) {
            sumRight -= nums[i];
            // 若左侧元素和等于右侧元素和，返回中心下标 i
            if (sumLeft == sumRight)
                return i;
            sumLeft += nums[i];
        }
        return -1;
    }
};
```

## 复杂度分析

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为数组 `nums` 长度。求和操作使用 $O(N)$ 线性时间，遍历 `nums` 最差使用 $O(N)$ 线性时间。
- **空间复杂度 $O(1)$ ：** 变量 `sum_left` , `sum_right` 使用常数大小空间。
