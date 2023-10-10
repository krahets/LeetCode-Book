## 解题思路：

本题的难点在于 **不能使用除法** ，即需要 **只用乘法** 生成数组 $B$ 。根据题目对 $B[i]$ 的定义，可列表格，如下图所示。

根据表格的主对角线（全为 $1$ ），可将表格分为 **上三角** 和 **下三角** 两部分。分别迭代计算下三角和上三角两部分的乘积，即可 **不使用除法** 就获得结果。

![Picture1.png](https://pic.leetcode-cn.com/1624619180-vpyyqh-Picture1.png){:width=500}

### 算法流程：

1. 初始化：数组 $B$ ，其中 $B[0] = 1$ ；辅助变量 $tmp = 1$ ；
2. 计算 $B[i]$ 的 **下三角** 各元素的乘积，直接乘入 $B[i]$ ；
3. 计算 $B[i]$ 的 **上三角** 各元素的乘积，记为 $tmp$ ，并乘入 $B[i]$ ；
4. 返回 $B$ 。

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为数组长度，两轮遍历数组 $a$ ，使用 $O(N)$ 时间。
- **空间复杂度 $O(1)$ ：** 变量 $tmp$ 使用常数大小额外空间（数组 $b$ 作为返回值，不计入复杂度考虑）。

<![Picture2.png](https://pic.leetcode-cn.com/1599920669-VflJdy-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1599920669-hLhpTV-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599920669-atltNE-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599920669-qHySih-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599920669-qmJFXC-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599920669-zaVZDZ-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599920669-ufmhnT-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1599920669-JBtgsZ-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599920669-thDqmQ-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599920669-QvVjSS-Picture11.png)>

## 代码：

```Python []
class Solution:
    def constructArr(self, a: List[int]) -> List[int]:
        b, tmp = [1] * len(a), 1
        for i in range(1, len(a)):
            b[i] = b[i - 1] * a[i - 1] # 下三角
        for i in range(len(a) - 2, -1, -1):
            tmp *= a[i + 1]            # 上三角
            b[i] *= tmp                # 下三角 * 上三角
        return b
```

```Java []
class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
```

```C++ []
class Solution {
public:
    vector<int> constructArr(vector<int>& a) {
        int len = a.size();
        if(len == 0) return {};
        vector<int> b(len, 1);
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
};
```
