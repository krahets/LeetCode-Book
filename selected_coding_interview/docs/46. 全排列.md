## 解题思路：

对于一个长度为 $n$ 的数组（假设元素互不重复），其排列方案数共有：

$$
n \times (n-1) \times (n-2) … \times 2 \times 1
$$

**排列方案的生成：**

根据数组排列的特点，考虑深度优先搜索所有排列方案。即通过元素交换，先固定第 $1$ 位元素（ $n$ 种情况）、再固定第 $2$ 位元素（ $n-1$ 种情况）、... 、最后固定第 $n$ 位元素（ $1$ 种情况）。

![Picture1.png](https://pic.leetcode.cn/1690622875-QNAmSJ-Picture1.png)
{:width=500}

### 递归解析：

1. **终止条件：** 当 `x = len(nums) - 1`  时，代表所有位已固定（最后一位只有 $1$ 种情况），则将当前组合 `nums` 转化为数组并加入 `res` ，并返回。
2. **递推参数：** 当前固定位 `x` 。
3. **递推工作：** 将第 `x` 位元素与 `i` $\in$ `[x, len(nums)]` 元素分别交换，并进入下层递归。
   1. **固定元素：** 将元素 `nums[i]` 和 `nums[x]` 交换，即固定 `nums[i]` 为当前位元素。
   2. **开启下层递归：** 调用 `dfs(x + 1)` ，即开始固定第 `x + 1` 个元素。
   3. **还原交换：** 将元素 `nums[i]` 和 `nums[x]` 交换（还原之前的交换）。

> 下图中 `list` 对应文中的列表 `nums` ，`"abc"` 对应 `123` 。

<![Picture3.png](https://pic.leetcode-cn.com/1599403497-OCDfsB-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599403497-wEILvT-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599403497-eBHuvg-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599403497-hCtrpl-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599403497-BvuqQX-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599403497-QPjcfe-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1599403497-crBxOP-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599403497-lwELHl-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599403497-yjHsYa-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1599403497-oYRpaR-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1599403497-CadkyC-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/1599403497-Sbywbs-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/1599403497-RNgwPK-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/1599403497-nOToNd-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/1599403497-ddKpYy-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/1599403497-xvTQhj-Picture18.png)>

## 代码：

```Python []
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs(x):
            if x == len(nums) - 1:
                res.append(list(nums))   # 添加排列方案
                return
            for i in range(x, len(nums)):
                nums[i], nums[x] = nums[x], nums[i]  # 交换，将 nums[i] 固定在第 x 位
                dfs(x + 1)                           # 开启固定第 x + 1 位元素
                nums[i], nums[x] = nums[x], nums[i]  # 恢复交换
        res = []
        dfs(0)
        return res
```

```Java []
class Solution {
    List<Integer> nums;
    List<List<Integer>> res;

    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));  // 添加排列方案
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);              // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;
    }
}
```

```C++ []
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        dfs(nums, 0);
        return res;
    }
private:
    vector<vector<int>> res;
    void dfs(vector<int> nums, int x) {
        if (x == nums.size() - 1) {
            res.push_back(nums);      // 添加排列方案
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            swap(nums[i], nums[x]);   // 交换，将 nums[i] 固定在第 x 位
            dfs(nums, x + 1);         // 开启固定第 x + 1 位元素
            swap(nums[i], nums[x]);   // 恢复交换
        }
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N!N)$ ：** $N$ 为数组 `nums` 的长度；时间复杂度和数组排列的方案数成线性关系，方案数为 $N \times (N-1) \times (N-2) … \times 2 \times 1$ ，即复杂度为 $O(N!)$ ；数组拼接操作 `join()` 使用 $O(N)$ ；因此总体时间复杂度为 $O(N!N)$ 。
- **空间复杂度 $O(N)$ ：** 全排列的递归深度为 $N$ ，系统累计使用栈空间大小为 $O(N)$ 。
