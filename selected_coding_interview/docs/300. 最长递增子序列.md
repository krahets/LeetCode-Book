### 解法一：动态规划

#### 解题思路：

- **状态定义：**
    - $dp[i]$ 的值代表 `nums` 以 $nums[i]$ 结尾的最长子序列长度。

- **转移方程：** 设 $j∈[0,i)$，考虑每轮计算新 $dp[i]$ 时，遍历 $[0,i)$ 列表区间，做以下判断：
    1. **当 $nums[i] > nums[j]$ 时：** $nums[i]$ 可以接在 $nums[j]$ 之后（此题要求严格递增），此情况下最长上升子序列长度为 $dp[j] + 1$ ；
    2. **当 $nums[i] <= nums[j]$ 时：** $nums[i]$ 无法接在 $nums[j]$ 之后，此情况上升子序列不成立，跳过。
    - 上述所有 **`1.` 情况** 下计算出的 $dp[j] + 1$ 的最大值，为直到 $i$ 的最长上升子序列长度（即 $dp[i]$ ）。实现方式为遍历 $j$ 时，每轮执行 $dp[i] = max(dp[i], dp[j] + 1)$。
    -  **转移方程：** `dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)`。

- **初始状态：**
    - $dp[i]$ 所有元素置 $1$，含义是每个元素都至少可以单独成为子序列，此时长度都为 $1$。 

- **返回值：**
    - 返回 $dp$ 列表最大值，即可得到全局最长上升子序列长度。

#### 复杂度分析：

- **时间复杂度 $O(N^2)$ ：** 遍历计算 $dp$ 列表需 $O(N)$，计算每个 $dp[i]$ 需 $O(N)$。
- **空间复杂度 $O(N)$ ：** $dp$ 列表占用线性大小额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/7ae911e51d39c7007ad8d548566abe40a84e5deb3cd682fd071080cd307f71f5-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/2863957adc210331a4454ff24c6a0565f72897735dc12173efa5410bd5f060aa-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/aca93162058a9825e85ec0c87b425ea830221028d6a29756f2a993adbe5a98e8-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/2dd92dc3eee45f119955ea2e445755da8ed6e6d2dc4bb4b0338a6a9f266a93b5-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/88fc673aa96730ba74fd0e48a008c6cb42d3418c7eea3420164567dc2d169c68-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/6ed0c9d9bf8025d3f025fb6d490e5d9c060c6e2185cf8d4e09b2de26e8ead96c-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/2e397f35f3581beae8cca9826626e19728b32b33b1c53d6e0e5d57536960d07c-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/256750c5adaf3eed7c3c7fda9b179d27a36e711d2bce84e2dc2b2caf28dc01cd-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/50a58365f776243eb0c1edfda3c4ae350af5c80f2377b850e759d2b38d26e9db-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/f16e1a6824530727306850eb12ff4aea78ecdaaa80a2cbafccb57ac7687340e0-Picture10.png)>

#### 代码：

```Python []
# Dynamic programming.
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]: # 如果要求非严格递增，将此行 '<' 改为 '<=' 即可。
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
```

```Java []
// Dynamic programming.
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

---

### 解法二：动态规划 + 二分查找

#### 解题思路：

- **降低复杂度切入点：** 解法一中，遍历计算 $dp$ 列表需 $O(N)$，计算每个 $dp[k]$ 需 $O(N)$。
    1. 动态规划中，通过线性遍历来计算 $dp$ 的复杂度无法降低；
    2. 每轮计算中，需要通过线性遍历 $[0,k)$ 区间元素来得到 $dp[k]$ 。我们考虑：是否可以通过重新设计**状态定义**，使整个 $dp$ 为一个**排序列表**；这样在计算每个 $dp[k]$ 时，就可以通过二分法遍历 $[0,k)$ 区间元素，将此部分复杂度由 $O(N)$ 降至 $O(logN)$。

- **设计思路：**
    - **新的状态定义：** 
        - 我们考虑维护一个列表 $tails$，其中每个元素 $tails[k]$ 的值代表 **长度为 $k+1$ 的子序列尾部元素的值**。
        - 如 $[1,4,6]$ 序列，长度为 $1,2,3$ 的子序列尾部元素值分别为 $tails = [1,4,6]$。
    - **状态转移设计：**
        - 设常量数字 $N$，和随机数字 $x$，我们可以容易推出：当 $N$ 越小时，$N<x$ 的几率越大。例如： $N=0$ 肯定比 $N=1000$ 更可能满足 $N<x$。
        - 在遍历计算每个 $tails[k]$，不断更新长度为 $[1,k]$ 的子序列尾部元素值，**始终保持每个尾部元素值最小** （例如 $[1,5,3]]$， 遍历到元素 $5$ 时，长度为 $2$ 的子序列尾部元素值为 $5$；当遍历到元素 $3$ 时，尾部元素值应更新至 $3$，因为 $3$ 遇到比它大的数字的几率更大）。
    - **$tails$ 列表一定是严格递增的：** 即当尽可能使每个子序列尾部元素值最小的前提下，子序列越长，其序列尾部元素值一定更大。
        - **反证法证明：** 当 $k < i$，若 $tails[k] >= tails[i]$，代表较短子序列的尾部元素的值 $>$ 较长子序列的尾部元素的值。这是不可能的，因为从长度为 $i$ 的子序列尾部倒序删除 $i-1$ 个元素，剩下的为长度为 $k$ 的子序列，设此序列尾部元素值为 $v$，则一定有 $v<tails[i]$ （即长度为 $k$ 的子序列尾部元素值一定更小）， 这和 $tails[k]>=tails[i]$ 矛盾。
        - 既然严格递增，每轮计算 $tails[k]$ 时就可以使用二分法查找需要更新的尾部元素值的对应索引 $i$。

- **算法流程：**
    - **状态定义：**
        - $tails[k]$ 的值代表 长度为 $k+1$ 子序列 的尾部元素值。

    - **转移方程：** 设 $res$ 为 $tails$ 当前长度，代表直到当前的最长上升子序列长度。设 $j∈[0,res)$，考虑每轮遍历 $nums[k]$ 时，通过二分法遍历 $[0,res)$ 列表区间，找出 $nums[k]$ 的大小分界点，会出现两种情况：
        - **区间中存在 $tails[i] > nums[k]$ ：** 将第一个满足 $tails[i] > nums[k]$ 执行 $tails[i] = nums[k]$ ；因为更小的 $nums[k]$ 后更可能接一个比它大的数字（前面分析过）。
        - **区间中不存在 $tails[i] > nums[k]$ ：** 意味着 $nums[k]$ 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 $res$ ），新子序列长度为 $res + 1$。

    - **初始状态：**
        - 令 $tails$ 列表所有值 $=0$。

    - **返回值：**
        - 返回 $res$ ，即最长上升子子序列长度。

#### 复杂度分析：

- **时间复杂度 $O(NlogN)$ ：** 遍历 $nums$ 列表需 $O(N)$，在每个 $nums[i]$ 二分法需 $O(logN)$。
- **空间复杂度 $O(N)$ ：** $tails$ 列表占用线性大小额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/821fe904ca7fcbbf309407ad7e41952b29d6b1d6989c471f4358e7e1dc52e416-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/bedbea1f343fde9e4b1f6b4ac982772c0a095e4ddc17c6c024974845fd976f7e-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/57777040c66f1ca8748ac2d6eaec93256f1a458ad2a219e9d166ee9aef608f66-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/fcc402f5a7c21681405486afa65403b237e80639740e244a909adaaa6873867d-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/c99b3eeca827a2f1c5e55f15131e81f463150e9db62906722457264f1328032b-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/095b564bc8dd16475cc149e166fca5a3d059ddaee19fe555f4b4085ee8e439c4-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/4eb096bf01e1c1879c2b17a1c298341a4de4f48d9292127020781448c4f4dc78-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/6808e0f2ef1ba669aaf93252c3262b5442e0ab5689bec16ada3af29866e11e64-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/c8f6a8543a627e2a2d07e1b6d8b3f142e0b8844fd639acb553a9654d564f4a8b-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/392dcb5a0af00923cbe014e529044491f327d8889ff4cc13e80fdf080b50eb94-Picture10.png)>

#### 代码：

```Python []
# Dynamic programming + Dichotomy.
class Solution:
    def lengthOfLIS(self, nums: [int]) -> int:
        tails, res = [0] * len(nums), 0
        for num in nums:
            i, j = 0, res
            while i < j:
                m = (i + j) // 2
                if tails[m] < num: i = m + 1 # 如果要求非严格递增，将此行 '<' 改为 '<=' 即可。
                else: j = m
            tails[i] = num
            if j == res: res += 1
        return res
```

```Java []
// Dynamic programming + Dichotomy.
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
```
