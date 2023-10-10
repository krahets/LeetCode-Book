### 解题思路：

- **规则定义：** 设学生 $A$ 和学生 $B$ 左右相邻，$A$ 在 $B$ 左边；
  - **左规则：** 当 $ratings_B>ratings_A$时，$B$ 的糖比 $A$ 的糖数量多。
  - **右规则：** 当 $ratings_A>ratings_B$时，$A$ 的糖比 $B$ 的糖数量多。

> 相邻的学生中，评分高的学生必须获得更多的糖果 **等价于** 所有学生满足左规则且满足右规则。

- **算法流程：**

  1. 先从左至右遍历学生成绩 `ratings`，按照以下规则给糖，并记录在 `left` 中：

     1. 先给所有学生 $1$ 颗糖；
     2. 若 $ratings_i>ratings_{i-1}$，则第 $i$ 名学生糖比第 $i - 1$ 名学生多 $1$ 个。
     3. 若 $ratings_i<=ratings_{i-1}$，则第 $i$ 名学生糖数量不变。（交由从右向左遍历时处理。）

     - 经过此规则分配后，可以保证所有学生糖数量 **满足左规则** 。

  2. 同理，在此规则下从右至左遍历学生成绩并记录在 `right` 中，可以保证所有学生糖数量 **满足右规则** 。
  3. 最终，取以上 $2$ 轮遍历 `left` 和 `right` 对应学生糖果数的 **最大值** ，这样则 **同时满足左规则和右规则** ，即得到每个同学的最少糖果数量。

- **复杂度分析：**
  - **时间复杂度 $O(N)$ ：** 遍历两遍数组即可得到结果；
  - **空间复杂度 $O(N)$ ：**  需要借用 `left`，`right` 的线性额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/d86caec88575aa1cd162c76401b3cc67f25105c178b9f99c51fdd34d877413d7-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/03f9b526fb71f0f06b98c2a6b68ba1032fa377c8847fa8879919d50f684786f2-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/a86dffd2c9800768229d87a3bdf4d0a3a3b71098faee7c85bdff68413ae46914-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/62ea88df951fd517365a0cb131ecb3268c1e96f7daaa71f63e888fa6b763cd1c-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/7f03142760a933dae495e460bb64bc0f7cc88c195d83d14579734880d189***-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/239ed1c324499af7774a0086d32f2ba7a95de58ebad605f29c5c2574cb9c344f-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/a19a2034c7ff1e2b8255338732a3f5417a5e2ed8aa2e672b2cd083fb2776ce5a-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/6cc40c14fa425f8aa7e771f19c61c487c1eef78efc675b029716998cb92645c9-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1312e225c83d51fadf246a9683b7c169fa3993bd169016ce93323466c85bfa1b-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/164a4bae4eacfcbd0d5bad0aaf11f215fb2847470f6cb1d5eaca2d8b13c1dc61-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/9e026380b05a72950a2056d6db588600f60701ec563da72e59fa1f8d6a810c95-Picture11.png)>

#### 代码：

```Python []
class Solution:
    def candy(self, ratings: List[int]) -> int:
        left = [1 for _ in range(len(ratings))]
        right = left[:]
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]: left[i] = left[i - 1] + 1
        count = left[-1]
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]: right[i] = right[i + 1] + 1
            count += max(left[i], right[i])
        return count
```

```Java []
class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
```
