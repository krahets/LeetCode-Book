## 解题思路

此题使用求和公式暴力求解的效率较低，因为包含大量重复计算。考虑借助「前一个动态和 $f(i-1)$ 」来计算得到「当前动态和 $f(i)$ 」，此题被约化为一个简单动态规划问题。

- **状态定义：** 设前 $i + 1$ 个数字的和为 $f(i)$ ；
- **初始状态：** $f(0) = nums[0]$ ；
- **转移方程：** $f(i) = f(i - 1) + nums[i]$ ；
- **待求数值：** $f(n - 1)$ ，其中 $n$ 为数组 $nums$ 长度；

![figures.gif](https://pic.leetcode-cn.com/1656947894-plQeLa-figures.gif)

> 上为动态图，下为静态图，内容一致。

<![Slide1.png](https://pic.leetcode-cn.com/1656947891-pEkkWS-Slide1.png),![Slide2.png](https://pic.leetcode-cn.com/1656947891-oghoMP-Slide2.png),![Slide3.png](https://pic.leetcode-cn.com/1656947891-qYfgqN-Slide3.png),![Slide4.png](https://pic.leetcode-cn.com/1656947891-YdeiAN-Slide4.png),![Slide5.png](https://pic.leetcode-cn.com/1656947891-mdAwvE-Slide5.png),![Slide6.png](https://pic.leetcode-cn.com/1656947891-uMLAOx-Slide6.png),![Slide7.png](https://pic.leetcode-cn.com/1656947891-UulRux-Slide7.png),![Slide8.png](https://pic.leetcode-cn.com/1656947891-hhgQjX-Slide8.png)>

## 代码

细心的我们发现，如果原地修改 `nums` ，可以避免新建 `dp` 带来的内存开销。但通常情况下，不应改变输入变量，因此不建议原地修改 `nums` 数组。

```Python []
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            dp[i] = dp[i - 1] + nums[i]
        return dp
```

```Java []
class Solution {
    public int[] runningSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
}
```

```C++ []
class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
};
```

## 复杂度分析

- **时间复杂度 $O(N)$ ：** 遍历 `nums` 使用线性时间。
- **空间复杂度 $O(1)$ ：** 用于保存结果的  `dp` 是必须使用的空间，此处不计入。
