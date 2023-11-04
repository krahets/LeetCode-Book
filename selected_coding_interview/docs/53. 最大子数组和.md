## 解题思路：

动态规划是本题的最优解法，以下按照标准流程解题。

| 常见解法 | 时间复杂度    | 空间复杂度  |
| -------- | ------------- | ----------- |
| 暴力搜索 | $O(N^2)$      | $O(1)$      |
| 分治思想 | $O(N \log N)$ | $O(\log N)$ |
| 动态规划 | $O(N)$        | $O(1)$      |

### 动态规划解析：

- **状态定义：** 设动态规划列表 $dp$ ，$dp[i]$ 代表以元素 $nums[i]$ 为结尾的连续子数组最大和。
  - 为何定义最大和 $dp[i]$ 中必须包含元素 $nums[i]$ ：保证 $dp[i]$ 递推到 $dp[i+1]$ 的正确性；如果不包含 $nums[i]$ ，递推时则不满足题目的 **连续子数组** 要求。

- **转移方程：** 若 $dp[i-1] \leq 0$ ，说明 $dp[i - 1]$ 对 $dp[i]$ 产生负贡献，即 $dp[i-1] + nums[i]$ 还不如 $nums[i]$ 本身大。

$$
dp[i] =
\begin{cases}
 dp[i-1] + nums[i] & , dp[i - 1] > 0 \\
 nums[i] & , dp[i - 1] \leq 0 \\
\end{cases}
$$

- **初始状态：** $dp[0] = nums[0]$，即以 $nums[0]$ 结尾的连续子数组最大和为 $nums[0]$ 。

- **返回值：** 返回 $dp$ 列表中的最大值，代表全局最大值。

![Picture1.png](https://pic.leetcode-cn.com/77d1aa6a444743d3c8606ac951cd7fc38faf68a62064fd2639df517cd666a4d0-Picture1.png){:width=500}

### 状态压缩：

- 由于 $dp[i]$ 只与 $dp[i-1]$ 和 $nums[i]$ 有关系，因此可以将原数组 $nums$ 用作 $dp$ 列表，即直接在 $nums$ 上修改即可。
- 由于省去 $dp$ 列表使用的额外空间，因此空间复杂度从 $O(N)$ 降至 $O(1)$ 。

<![Picture2.png](https://pic.leetcode-cn.com/c05fcc23f37290d4445ea7ee0ff4e0217fa9d7a0d0fdada765672900590d7ecd-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/384a20d1538b3fecda3e64f36e6a1cffb2e90aa3def9a06457c0ab5495202f64-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/79596dec42eedd88012ce0b06ede6fcd76fdb61140551503deda234005f22f5c-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/0ad8500b80f4705ab0458d46cf4e9228177373fed84187948352df11a133cc18-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/e1cad157f82a37d6960a660e7e648e81da6875e912edd613b10ab639f87674c2-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/269dbec6c7e0c7580cd74d60d151c651a7cee9a6a0feb4229a3a8a5f2062afca-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/b1218b8594854c40f048db7bce3bb163d41163fc1eef03d8aa4135c8c23ec911-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/ff0d403e4de402ec0a4122cdb66a9262f93a4986442b18dbb1655fe367052a25-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1fde43a35e65c800a274e2dd46fe9641ce38e215ff85a73a8d7e5d26163fe17e-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/86e7af90fbef1c11702fb72132df9b5fb2b33e13585d7ef67268fdf74d8611d4-Picture11.png)>

## 代码：

```Python []
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):
            nums[i] += max(nums[i - 1], 0)
        return max(nums)
```

```Java []
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
```

```C++ []
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0];
        for(int i = 1; i < nums.size(); i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            if (nums[i] > res) res = nums[i];
        }
        return res;  
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 线性遍历数组 $nums$ 即可获得结果，使用 $O(N)$ 时间。
- **空间复杂度 $O(1)$ ：** 使用常数大小的额外空间。
