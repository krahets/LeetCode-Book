### 解题思路：

此题是典型的动态规划题目。

- **状态定义：**
    - 设 $dp$ 为大小 $m \times n$ 矩阵，其中 $dp[i][j]$ 的值代表直到走到 $(i,j)$ 的最小路径和。

- **转移方程：** 
    > 题目要求，只能向右或向下走，换句话说，当前单元格 $(i,j)$ 只能从左方单元格 $(i-1,j)$ 或上方单元格 $(i,j-1)$ 走到，因此只需要考虑矩阵左边界和上边界。
    - 走到当前单元格 $(i,j)$ 的最小路径和 $=$ “从左方单元格 $(i-1,j)$ 与 从上方单元格 $(i,j-1)$ 走来的 **两个最小路径和中较小的** ” $+$ 当前单元格值 $grid[i][j]$ 。具体分为以下 $4$ 种情况：
    1. **当左边和上边都不是矩阵边界时：** 即当$i \not= 0$, $j \not= 0$时，$dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]$ ；
    2. **当只有左边是矩阵边界时：** 只能从上面来，即当$i = 0, j \not= 0$时， $dp[i][j] = dp[i][j - 1] + grid[i][j]$ ；
    3. **当只有上边是矩阵边界时：** 只能从左面来，即当$i \not= 0, j = 0$时， $dp[i][j] = dp[i - 1][j] + grid[i][j]$ ；
    4. **当左边和上边都是矩阵边界时：** 即当$i = 0, j = 0$时，其实就是起点， $dp[i][j] = grid[i][j]$；

- **初始状态：**
    - $dp$ 初始化即可，不需要修改初始 $0$ 值。 

- **返回值：**
    - 返回 $dp$ 矩阵右下角值，即走到终点的最小路径和。

其实我们完全不需要建立 $dp$ 矩阵浪费额外空间，直接遍历 $grid[i][j]$ 修改即可。这是因为：`grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]` ；原 $grid$ 矩阵元素中被覆盖为 $dp$ 元素后（都处于当前遍历点的左上方），不会再被使用到。

#### 复杂度分析：

- **时间复杂度 $O(M \times N)$ ：** 遍历整个 $grid$ 矩阵元素。
- **空间复杂度 $O(1)$ ：** 直接修改原矩阵，不使用额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/c32cf8caeabc08a2a759bb0eff310cfa3a424617e3b2f342d18a4ce6e1b450c8-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/9d45c8b3fe3111048b1e24a21ae5a7bc16b8c431e62ada811136152d43e2d27e-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/a2d4f3fdafdbc564d5b8bf63385601feb7269f72bbb716eb031120d9bea7921f-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/b93a6e07cdc774a051bd7abef8fe9c99d582a07b89c1f7e43edfc9921df2f773-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/a833e2fe055ce5f996852681821517c3aa6da792f2c24b67f7840db90f5f805c-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/f7b184924ac3b0e01f779321754bc98b5322351ee2791d04f3a15d83e4ce2fff-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/c1e79968a0d3a5874174848db4cd5fbe2a90c13a4ce8014779604999556c9325-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/c36939bb0deeb5b6170d53017527b161c8365cf232f5a94cb660181c5b1001c2-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/dc0811c743893c3d18ad3f12e15f310506748429ab1df814cddce43069ab607e-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/488267d5cadfbd697d92311a79ad6c64aec64e018ef094cf2df71cac491d69ca-Picture10.png)>

#### 代码：

```Python []
class Solution:
    def minPathSum(self, grid: [[int]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == j == 0: continue
                elif i == 0:  grid[i][j] = grid[i][j - 1] + grid[i][j]
                elif j == 0:  grid[i][j] = grid[i - 1][j] + grid[i][j]
                else: grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
        return grid[-1][-1]
```

```Java []
class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
```
