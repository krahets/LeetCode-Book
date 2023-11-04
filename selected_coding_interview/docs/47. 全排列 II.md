## 解题思路：

请先做前置题目「[46. 全排列](https://leetcode.cn/problems/permutations/solutions/2363882/46-quan-pai-lie-hui-su-qing-xi-tu-jie-by-6o7h/)」。

本题和上一题的区别是数组中“存在重复元素”。当数组存在重复元素时，排列方案中也存在重复的排列方案。

为了排除这些重复方案，需在固定某位元素时，保证“每种元素只在此位固定一次”，**即遇到重复元素时不交换，直接跳过**，从而将生成重复排列的搜索分支进行“剪枝” 。

![Picture2.png](https://pic.leetcode.cn/1690622903-LENLFB-Picture2.png)
{:width=500}

### 递归解析：

1. **终止条件：** 当 `x = len(nums) - 1`  时，代表所有位已固定（最后一位只有 $1$ 种情况），则将当前组合 `nums` 转化为数组并加入 `res` ，并返回。
2. **递推参数：** 当前固定位 `x` 。
3. **递推工作：** 初始化一个 Set ，用于排除重复的元素；将第 `x` 位元素与 `i` $\in$ `[x, len(nums)]` 元素分别交换，并进入下层递归。
   1. **剪枝：** 若 `nums[i]` 在 Set​ 中，代表其是重复元素，因此 “剪枝” 。
   2. 将 `nums[i]` 加入 Set​ ，以便之后遇到重复元素时剪枝。
   3. **固定元素：** 将元素 `nums[i]` 和 `nums[x]` 交换，即固定 `nums[i]` 为当前位元素。
   4. **开启下层递归：** 调用 `dfs(x + 1)` ，即开始固定第 `x + 1` 个元素。
   5. **还原交换：** 将元素 `nums[i]` 和 `nums[x]` 交换（还原之前的交换）。

> 下图中 `list` 对应文中的列表 `nums` ，`"abc"` 对应 `123` 。

<![Picture3.png](https://pic.leetcode-cn.com/1599403497-OCDfsB-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599403497-wEILvT-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599403497-eBHuvg-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599403497-hCtrpl-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599403497-BvuqQX-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599403497-QPjcfe-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1599403497-crBxOP-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599403497-lwELHl-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599403497-yjHsYa-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1599403497-oYRpaR-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1599403497-CadkyC-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/1599403497-Sbywbs-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/1599403497-RNgwPK-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/1599403497-nOToNd-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/1599403497-ddKpYy-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/1599403497-xvTQhj-Picture18.png)>

## 代码：

```Python []
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        def dfs(x):
            if x == len(nums) - 1:
                res.append(list(nums))   # 添加排列方案
                return
            dic = set()
            for i in range(x, len(nums)):
                if nums[i] in dic: continue # 重复，因此剪枝
                dic.add(nums[i])
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < nums.size(); i++) {
            if (set.contains(nums.get(i)))
                continue;            // 重复，因此剪枝
            set.add(nums.get(i));
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);              // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
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
    vector<vector<int>> permuteUnique(vector<int>& nums) {
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
        set<int> st;
        for (int i = x; i < nums.size(); i++) {
            if (st.find(nums[i]) != st.end())
                continue;             // 重复，因此剪枝
            st.insert(nums[i]);
            swap(nums[i], nums[x]);   // 交换，将 nums[i] 固定在第 x 位
            dfs(nums, x + 1);         // 开启固定第 x + 1 位元素
            swap(nums[i], nums[x]);   // 恢复交换
        }
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N!N)$ ：** 与上一题相同 。
- **空间复杂度 $O(N^2)$ ：** 递归中辅助 Set 累计存储的元素数量最多为 $N + (N-1) + ... + 2 + 1 = (N+1)N/2$ ，因此占用 $O(N^2)$ 的额外空间。
