### 解题思路：

#### 总体思路：

- **此题是 [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/) 的拓展版：** 唯一的区别是此题中的房间是 **环状排列** 的（即首尾相接），而 $198.$ 题中的房间是 **单排排列** 的；而这也是此题的难点。

- **环状排列** 意味着第一个房子和最后一个房子中 **只能选择一个偷窃**，因此可以把此 **环状排列房间** 问题约化为两个 **单排排列房间** 子问题：

  1. 在不偷窃第一个房子的情况下（即 $nums[1:]$），最大金额是 $p_1$ ；
  2. 在不偷窃最后一个房子的情况下（即 $nums[:n-1]$），最大金额是 $p_2$ 。

  - **综合偷窃最大金额：** 为以上两种情况的较大值，即 $max(p1,p2)$ 。

- 下面的任务则是解决 **单排排列房间（即 [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/)）** 问题。推荐可以先把 $198.$ 做完再做这道题。

#### 198. 解题思路：

典型的动态规划，以下按照标准流程解题。

- **状态定义：**
  - 设动态规划列表 $dp$ ，$dp[i]$ 代表前 $i$ 个房子在满足条件下的能偷窃到的最高金额。
- **转移方程：**
  - **设：** 有 $n$ 个房子，前 $n$ 间能偷窃到的最高金额是 $dp[n]$ ，前 $n-1$ 间能偷窃到的最高金额是 $dp[n-1]$ ，此时向这些房子后加一间房，此房间价值为 $num$ ；
  - **加一间房间后：** 由于不能抢相邻的房子，意味着抢第 $n+1$ 间就不能抢第 $n$ 间；那么前 $n+1$ 间房能偷取到的最高金额 $dp[n+1]$ 一定是以下两种情况的 **较大值** ：
    1. 不抢第 $n+1$ 个房间，因此等于前 $n$ 个房子的最高金额，即 $dp[n+1] = dp[n]$ ；
    2. 抢第 $n+1$ 个房间，此时不能抢第 $n$ 个房间；因此等于前 $n-1$ 个房子的最高金额加上当前房间价值，即 $dp[n+1] = dp[n-1] + num$ ；
  - **细心的我们发现：** 难道在前 $n$ 间的最高金额 $dp[n]$ 情况下，第 $n$ 间一定被偷了吗？假设没有被偷，那 $n+1$ 间的最大值应该也可能是  $dp[n+1] = dp[n] + num$ 吧？其实这种假设的情况可以被省略，这是因为：
    1. 假设第 $n$ 间没有被偷，那么此时 $dp[n] = dp[n-1]$ ，此时 $dp[n+1] = dp[n] + num = dp[n-1] + num$ ，即可以将 **两种情况合并为一种情况** 考虑；
    2. 假设第 $n$ 间被偷，那么此时 $dp[n+1] = dp[n] + num$ **不可取** ，因为偷了第 $n$ 间就不能偷第 $n+1$ 间。
  - **最终的转移方程：** $dp[n+1] = max(dp[n],dp[n-1]+num)$
- **初始状态：**
  - 前 $0$ 间房子的最大偷窃价值为 $0$ ，即 $dp[0] = 0$ 。
- **返回值：**
  - 返回 $dp$ 列表最后一个元素值，即所有房间的最大偷窃价值。
- **简化空间复杂度：**
  - 我们发现 $dp[n]$ 只与 $dp[n-1]$ 和 $dp[n-2]$ 有关系，因此我们可以设两个变量 `cur`和 `pre` 交替记录，将空间复杂度降到 $O(1)$ 。

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 两次遍历 `nums` 需要线性时间；
- **空间复杂度 $O(1)$ ：** `cur`和 `pre` 使用常数大小的额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/ae512395fc10a22fdc4e22e2fcab394c3321eac42d8d1f28b306fefe1fa43b11-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/8c0542b663c975914a70e9d4c5753e50c00b10272846118f2c8f21717a5db639-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/0c802bf6ed5137d747794b406ee97d3b49772bf0c14e044914f86b01a72b9a94-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/cf6e6cab02fb996d9e6b77972758f4ff5ca9a0163c5224fd4b5d50778101f1a0-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/e5b4e986b1e815760226205fbb4aaa4aedace195c4b29e84cc0138b374605798-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/34e1af2897fda8d541a93cb79072e250feca60691dfa0a46150082ebf79603c1-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/b466bb392ca7bdef75cfaeae18dcbcd8722ad08e913c43dbcbac83fa9868b8f9-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/7e645390e53efb4f7754ac218875bd5fa3c639da577eedb24b198d7b50b4ac5a-Picture8.png)>

### 代码：

```Python []
class Solution:
    def rob(self, nums: [int]) -> int:
        def my_rob(nums):
            cur, pre = 0, 0
            for num in nums:
                cur, pre = max(pre + num, cur), cur
            return cur
        return max(my_rob(nums[:-1]),my_rob(nums[1:])) if len(nums) != 1 else nums[0]
```

```Java []
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
                        myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
```
